package org.example.jdbc.dml;

import static java.lang.System.out;
import static org.example.jdbc.Derby.*;
import static org.example.jdbc.ddl.Personas.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.jdbc.ddl.Personas;

class InsertarFilas {

	public static void main(String[] personas) throws SQLException {
		try (var sql = getConnection().prepareStatement("""
				INSERT 
				  INTO %s (nombre, apellidos, nif, edad) 
				VALUES    (?     , ?        , ?  , ?   )
				""".formatted(TABLA))) {
			if (personas.length == 0) {
				insert(sql, "SANTI");
			} else {
				for (String nombre : personas) {
					insert(sql, nombre);
				}	
			}
		}
	}
	
	private static void insert(PreparedStatement sql, String nombre) throws SQLException {
		var persona = Personas.valueOf(nombre);
		sql.setString(1, persona.nombre);
		sql.setString(2, persona.apellidos);
		sql.setString(3, persona.nif);
		sql.setInt(4, persona.edad);
		sql.execute();
		out.println("Se ha insertado un registro en la tabla '%s' ==> %s".formatted(TABLA, persona));		
	}

}