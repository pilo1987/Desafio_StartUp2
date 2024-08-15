package cl.praxis.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import cl.praxis.model.db.DB;
import cl.praxis.model.dto.DireccionesDTO;

public class DireccionesDAOImpl implements DireccionesDAO{

	@Override
	public void create(DireccionesDTO c) {
		
		try {
			
			Connection connect = DB.getConnect();

			Statement s = connect.createStatement();
			String sql = "insert into direcciones (nombre, numeracion, usuario_id) values "
					+ "('" + c.getNombre() + "','" + c.getNumeracion() + "','" + c.getUsuario_id() + "')";

			
		} catch (SQLException e) {
			System.out.println(" create(DireccionesDTO c)");
			e.printStackTrace();
		}
		
	}		

}
