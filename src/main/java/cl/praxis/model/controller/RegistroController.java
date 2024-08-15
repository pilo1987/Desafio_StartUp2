package cl.praxis.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dto.*;
import cl.praxis.model.dao.*;

@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegistroController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RolesDAO rolesDao =  new RolesDAOImpl();
		List<RolesDTO> rolesDTO = new ArrayList<RolesDTO>();
		rolesDTO = rolesDao.read();
		request.setAttribute("roles", rolesDTO);
		getServletContext().getRequestDispatcher("registro.jsp").forward(request, response);
	}	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuariosDAO usuariosDAO = new UsuariosDAOImpl();
		DireccionesDAO direccionesDAO = new DireccionesDAOImpl();
		RolesDAO rolesDAO = new RolesDAOImpl();
		
		// Obtiene los parámetros del formulario enviado por el cliente.
	    String correo = request.getParameter("correo");
	    String nick = request.getParameter("nick");
	    String nombre = request.getParameter("nombre");
	    String password = request.getParameter("password");
	    String pesoStr = request.getParameter("peso");
	    String numeracion = request.getParameter("numeracion");
	    String rolStr = request.getParameter("rol");

	    // Convierte el peso de String a int, maneja posibles errores.
	    int peso = 0;
	    try {
	        peso = Integer.parseInt(pesoStr);
	    } catch (NumberFormatException e) {
	        System.out.println("Error al convertir el peso a entero: " + e.getMessage());
	        response.sendRedirect("error.jsp"); // Redirige a una página de error si la conversión falla.
	        return;
	    }

	    // Crea una instancia de la clase DTO para almacenar los datos del usuario.
	    Date now = new Date(System.currentTimeMillis()); // Usa la fecha actual de manera precisa.
	    UsuariosDTO usuario = new UsuariosDTO();
	    usuario.setCorreo(correo);
	    usuario.setNick(nick);
	    usuario.setNombre(nombre);
	    usuario.setPassword(password);
	    usuario.setPeso(peso);
	    usuario.setCreated_at(now);
	    usuario.setUpdated_at(now);
			
	    try {
	        // Usa el DAO para guardar la información del usuario en la base de datos.
	        usuariosDAO.create(usuario);

	        // Obtén el ID del usuario recién creado.
	        int idUser = usuariosDAO.read(correo, rolStr).getId();

	        // Crea y guarda la dirección del usuario.
	        DireccionesDTO direccion = new DireccionesDTO(0, nombre, numeracion, idUser);
	        direccionesDAO.create(direccion);

	        // Crea y guarda el rol del usuario.
	        int rol = 0;
	        try {
	            rol = Integer.parseInt(rolStr);
	        } catch (NumberFormatException e) {
	            System.out.println("Error al convertir el rol a entero: " + e.getMessage());
	            response.sendRedirect("error.jsp"); // Redirige a una página de error si la conversión falla.
	            return;
	        }
	        Roles_UsuariosDTO rolesUsuario = new Roles_UsuariosDTO(idUser, rol);
	        rolesDAO.create(rolesUsuario);

	        // Redirige al usuario a la página principal después de la operación.
	        getServletContext().getRequestDispatcher("index.jsp").forward(request, response);

	    } catch (Exception e) {
	        e.printStackTrace();
	        // Redirige a una página de error si ocurre una excepción.
	        response.sendRedirect("error.jsp");
	    }
	}
}
