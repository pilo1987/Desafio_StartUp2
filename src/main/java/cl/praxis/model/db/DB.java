package cl.praxis.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Singleton para obtener una conexión a la base de datos.
 * Utiliza el patrón Singleton para asegurar que solo haya una instancia de conexión a la base de datos.
 */

public class DB {
	
	// Instancia única de conexión a la base de datos
	private static Connection connect = null;
	
	private DB() {
		try {
			
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/startupdb", "postgres", "aranibar18");
			
			System.out.println(connect.isValid(50000) ? "CONNECTION A BD - OK " : "CONNECTION BD FAILED");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error al conectar con la Base de Datos" + e.getMessage());
		}
	}
	
	public static Connection getConnect() {	
		if (connect == null) {
			new DB();
		}
		
		return connect;
	}	
}