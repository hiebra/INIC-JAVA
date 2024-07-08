package org.example.jdbc.ddl;

import static java.lang.System.*;
import static org.example.jdbc.Derby.*;

import java.sql.SQLException;

class BorrarTabla {

	public static void main(String[] args) throws SQLException {
		try (var db = getConnection(); var sql = db.createStatement()) {
			sql.execute("DROP TABLE %s".formatted(Personas.TABLA));
		}
		out.println("Se ha eliminado la tabla '%s'".formatted(Personas.TABLA));
	}
	
}