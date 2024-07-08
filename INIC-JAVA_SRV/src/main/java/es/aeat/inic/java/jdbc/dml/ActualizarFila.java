package es.aeat.inic.java.jdbc.dml;

import static es.aeat.inic.java.jdbc.Derby.*;
import static es.aeat.inic.java.jdbc.ddl.Personas.*;
import static java.lang.System.out;

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