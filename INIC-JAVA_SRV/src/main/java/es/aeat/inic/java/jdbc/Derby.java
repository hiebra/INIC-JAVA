package es.aeat.inic.java.jdbc;

import static java.lang.System.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Derby {

	private static String database = getProperty("org.example.database", "database");

	static {
		String home = getProperty("derby.system.home", getProperty("user.dir"));
		out.println("Base de datos en uso: %s (subdirectorio de %s)".formatted(database, home));
	}
	
	private static String url = "jdbc:derby:%s;create=true".formatted(database);
	
	public static Connection getConnection() {
		return getConnection(true);
	}
	
	public static Connection getConnection(boolean autocommit) {
		try {
			var connection = DriverManager.getConnection(url);
			connection.setAutoCommit(autocommit);
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					try {
						if (!connection.isClosed()) {
							connection.close();	
						}
					} catch (SQLException e) {
						throw new IllegalStateException(e);
					}
				}
			});
			return connection;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}
	
}