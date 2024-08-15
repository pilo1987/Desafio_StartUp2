package cl.praxis.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cl.praxis.model.dao.*;
import cl.praxis.model.dto.*;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		// Crea una instancia del DAO para interactuar con la base de datos.
		UsuariosDAO aDAO = new UsuariosDAOImpl();
		UsuariosDTO usuarios = aDAO.read(request.getParameter("correo"), request.getParameter("password"));
		System.out.println(usuarios);

		RolesDAO  pDAO = new RolesDAOImpl();
		
		int idAdmin = pDAO.idAdmin();
		System.out.println("idAmin="+idAdmin);
		
		int rolUser = pDAO.userRol(usuarios.getId()); 
		System.out.println("rolUser="+rolUser);
		
		if(idAdmin == rolUser) {
			System.out.println("Es admin");
			List<UsuariosDTO> users =new ArrayList<UsuariosDTO>();
			users = aDAO.read();
			System.out.println(users);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);	
		}
		else {
			System.out.println("No es admin");
			response.sendRedirect("error.jsp");
		}
		} catch (Exception e) {
			System.out.println("Error Null Pointer Excetion Login");
			response.sendRedirect("error.jsp");
		}
	}
}