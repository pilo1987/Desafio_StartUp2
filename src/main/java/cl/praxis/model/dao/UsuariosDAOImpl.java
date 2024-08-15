package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.model.db.DB;
import cl.praxis.model.dto.UsuariosDTO;

public class UsuariosDAOImpl implements UsuariosDAO {

	@Override
	public void create(UsuariosDTO c) {
		
		try {

			Connection connect = DB.getConnect();

			Statement s = connect.createStatement();
			String sql = "INSERT INTO usuarios ( correo, created_at, nick, nombre, password, peso, updated_at) VALUES (?,?,?,?,?,?,?)";

			try (PreparedStatement stmt = connect.prepareStatement(sql)) {
				        
				stmt.setString	(1, c.getCorreo());
		        stmt.setTimestamp(2, new Timestamp(c.getCreated_at().getTime()));
		        stmt.setString  (3, c.getNick());          
		        stmt.setString  (4, c.getNombre());        
		        stmt.setString  (5, c.getPassword());      
		        stmt.setInt     (6, c.getPeso());          
		        stmt.setTimestamp(7, new Timestamp(c.getUpdated_at().getTime())); // updated_at

				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			System.out.println("ERROR EN METODO CREATE ()");
			e.printStackTrace();
		}
	}

	@Override
	public UsuariosDTO read(String correo, String pass) {
		
UsuariosDTO usuarios = null;
		
	    String sql = "SELECT id, correo, created_at, nick, nombre, password, peso, updated_at FROM usuarios WHERE correo = ? AND password = ?";

	    
	    try (Connection connect = DB.getConnect();

	    		PreparedStatement stmt = connect.prepareStatement(sql)) {
	    	
	     
		    stmt.setString(1, correo);
	        stmt.setString(2, pass);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                usuarios = new UsuariosDTO(
	                    rs.getInt("id"),
	                    rs.getString("correo"),
	                    rs.getDate("created_at"),
	                    rs.getString("nick"),
	                    rs.getString("nombre"),
	                    rs.getString("password"),
	                    rs.getInt("peso"),
	                    rs.getDate("updated_at")
	                );
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR en read()");
	        e.printStackTrace();
	    }

	    return usuarios;
	}

	@Override
	public boolean verificaEmail(String correo) {
		try {

			// Establece conexión con la base de datos.
			Connection connect = DB.getConnect();

			// Crea un objeto Statement para ejecutar la consulta SQL.
			Statement s = connect.createStatement();

			// Construye la consulta SQL para buscar el correo electrónico en la base de
			// datos.
			String sql = "Select id From usuarios WHERE correo = '" + correo + "'";
			System.out.println(sql);

			// Ejecuta la consulta SQL y obtiene los resultados.
			ResultSet rs = s.executeQuery(sql);

			// Verifica si se encontró algún resultado.
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// Maneja las excepciones SQL, imprime un mensaje de error y la traza de la
			// excepción.
			System.out.println("ERROR en read(id)");
			e.printStackTrace();
		}

		// Si no se encontró ningún resultado o ocurrió una excepción, devuelve false.
		return false;
	}

	@Override
	public List<UsuariosDTO> read() {
		List<UsuariosDTO> usuariosDTO = new ArrayList<UsuariosDTO>();

		try {
			Connection connect = DB.getConnect();

			Statement s = connect.createStatement();
			String sql = "SELECT id, nombre, correo, created_at, nick, nombre, password,peso, updated_at FROM usuarios";

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				usuariosDTO.add(new UsuariosDTO(rs.getInt("id"), rs.getString("correo"), rs.getDate("created_at"),
						rs.getString("nick"), rs.getString("nombre"), rs.getString("password"), rs.getInt("peso"),
						rs.getDate("updated_at")));

			}

		} catch (SQLException e) {
			System.out.println("ERROR en read()");
			e.printStackTrace();
		}
		return usuariosDTO;
	}

	@Override
	public void update(UsuariosDTO u) {
		
	}

	@Override
	public String delete(int id) {
		return null;
	}

}
