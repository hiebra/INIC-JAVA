package org.example.jdbc.dml;

import static org.example.jdbc.Derby.*;
import static org.example.jdbc.ddl.Personas.*;

import java.sql.SQLException;

class BorrarFilas {

	public static void main(String[] args) throws SQLException {
		try (var sql = getConnection().prepareStatement("DELETE FROM %s WHERE edad > 59".formatted(TABLA))) {
			int deleted = sql.executeUpdate();
			System.out.println("Se han eliminado %d registros de la tabla %s".formatted(deleted, TABLA));
		}
	}
	
}
