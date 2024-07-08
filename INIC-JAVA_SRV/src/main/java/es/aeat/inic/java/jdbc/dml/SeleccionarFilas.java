package es.aeat.inic.java.jdbc.dml;

import static es.aeat.inic.java.jdbc.Derby.*;
import static es.aeat.inic.java.jdbc.ddl.Personas.*;
import static java.lang.System.out;

import java.sql.SQLException;

class SeleccionarFilas {

	public static void main(String[] args) throws SQLException {
		try (var sql = getConnection().prepareStatement("""
				SELECT id, nombre, apellidos, nif, edad
				  FROM %s
				 WHERE nif <> ?
				   AND edad < 60
				""".formatted(TABLA))) {
			sql.setString(1, "00000000?");
			var selected = sql.executeQuery();
			int count = 0;
			while (selected.next()) {
				count += 1;
				var id = selected.getInt(1);
				var nombre = selected.getString(2);
				var apellidos = selected.getString(3);
				var nif = selected.getString(4);
				var edad = selected.getInt(5);
				out.println("Persona seleccionada: %s %s, con NIF %s, %d años de edad e ID %06d".formatted(nombre, apellidos, nif, edad, id));
			}
			out.println("Total de personas seleccionadas: %d".formatted(count));
		}
	}

}