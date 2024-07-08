package org.example.jdbc.dml;

import static java.lang.System.out;
import static org.example.jdbc.Derby.*;
import static org.example.jdbc.ddl.Personas.*;

import java.sql.SQLException;

class ActualizarFila {

	public static void main(String[] args) throws SQLException {
		int jubilable = 60;
		try (var sql = getConnection().prepareStatement("""
				UPDATE %s 
				   SET edad = ?
				 WHERE nif = ?
				""".formatted(TABLA))) {
			sql.setInt(1, jubilable);
			sql.setString(2, SANTI.nif);
			int rows = sql.executeUpdate();
			if (rows == 0) {
				SANTI.edad = jubilable;
				InsertarFilas.main(new String[]{"SANTI"});
			}
			out.println("Se ha establecido la edad de SANTI a %d años".formatted(jubilable));
		}
	}

}