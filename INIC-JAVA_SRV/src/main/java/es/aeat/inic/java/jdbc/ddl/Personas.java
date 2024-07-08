package es.aeat.inic.java.jdbc.ddl;

public enum Personas {

	SANTI("Santiago", "Ruiz Hiebra", "12345678L", 53), LUISA("Luisa", "Otro Apellido", "00000000A", 36);

	public String nombre;
	public String apellidos;
	public String nif;
	public int edad;

	public static final String TABLA = "persona";
	public static final String CREATE_TABLE = """
			CREATE TABLE %s (
				id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
				nombre VARCHAR(64) NOT NULL,
				apellidos VARCHAR(128) NOT NULL,
				nif CHAR(9) UNIQUE NOT NULL,
				edad INTEGER NOT NULL
			)
			""".formatted(Personas.TABLA);

	Personas(String nombre, String apellidos, String nif, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Nombre: %s %s, NIF: %s".formatted(nombre, apellidos, nif);
	}

}