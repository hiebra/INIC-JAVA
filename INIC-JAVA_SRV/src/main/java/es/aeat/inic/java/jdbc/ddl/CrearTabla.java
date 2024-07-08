package es.aeat.inic.java.jdbc.ddl;

import static es.aeat.inic.java.jdbc.Derby.*;
import static java.lang.System.*;

import java.sql.SQLException;

class CrearTabla {

	public static void main(String[] args) throws SQLException {
		try (var sql = getConnection().createStatement()) {
			sql.execute(Personas.CREATE_TABLE);
		}
		out.println("Se ha creado la tabla '%s'".formatted(Personas.TABLA));
	}
	
}