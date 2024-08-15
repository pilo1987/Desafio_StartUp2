package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.model.db.DB;
import cl.praxis.model.dto.RolesDTO;
import cl.praxis.model.dto.Roles_UsuariosDTO;

public class RolesDAOImpl implements RolesDAO{

	@Override
	public List<RolesDTO> read() {
		List<RolesDTO> rolesDTO = new ArrayList<RolesDTO>();

		try {
			Connection connect = DB.getConnect();

			Statement s = connect.createStatement();
			String sql = "select id, nombre from roles";

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				rolesDTO.add(new RolesDTO(rs.getInt("id"), rs.getString("nombre")));

			}

		} catch (SQLException e) {
			System.out.println(" List<RolesDTO> read()");
			e.printStackTrace();
		}
		return rolesDTO;
	}


	@Override
	public void create(Roles_UsuariosDTO c) {
		
		try {
			Connection connect = DB.getConnect();

			Statement s = connect.createStatement();
			String sql = "insert into roles_usuarios ( usuario_id,  roles_id) values "
					+ "('" + c.getUsuario_id() + "','" + c.getRol_id() + "')";

			ResultSet re = s.executeQuery(sql);
			
		} catch (SQLException e) {
			System.out.println("create(Roles_usuariosDTO p)");
			e.printStackTrace();
		}
		
	}
		

	@Override
	public int idAdmin() {
		
		int admin = 0;
		RolesDTO p = null;
		
		try {
			Connection connect = DB.getConnect();

			Statement s = connect.createStatement();
			String sql = "select id, nombre from roles where nombre = 'Administrador'";

			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				p = new RolesDTO(rs.getInt("id"),rs.getString("nombre"));
			}
			System.out.println("RolEncontrado"+p.getId()+" "+p.getNombre());
			admin = p.getId();
			
		} catch (SQLException e) {
			System.out.println("idAdmin()");
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public int userRol(int userId) {
		
		int admin = 0;
		Roles_UsuariosDTO p = null;
		
		try {
			Connection connect = DB.getConnect();

			Statement s = connect.createStatement();
			String sql = "select usuario_id, roles_id from roles_usuarios where usuario_id = '"+userId+"'";
			System.out.println(sql);
			
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				p = new Roles_UsuariosDTO(rs.getInt("usuario_id"),rs.getInt("roles_id"));
			}
			System.out.println("RoldelUser"+ p.getRol_id());
			admin = p.getRol_id();
			
		} catch (SQLException e) {
			System.out.println("userRol(int userId)");
			e.printStackTrace();
		}
		return admin;
		
	}

}
