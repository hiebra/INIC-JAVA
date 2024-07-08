package es.aeat.inic.java.app.web.vehiculos;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.aeat.inic.java.vehiculos.Barco;

class ViajeEnBarcoPost {

	OutputStream out;
	String nombre;
	String destino;
	boolean tieneVela;
	Barco barco;
	
	ViajeEnBarcoPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		nombre = request.getParameter("nombre");
		destino = request.getParameter("destino");
		tieneVela = request.getParameter("tiene-vela") != null;
		validarParametros();
		out = response.getOutputStream();
		setBarco();
		viajar();
	}
	
	void setBarco() throws Exception {
		barco = new Barco(nombre, tieneVela, out);
	}
	
	void validarParametros() throws Exception {
		if (nombre.equals(null)) {
			throw new IllegalArgumentException("nombre");
		}
		if (destino.equals(null)) {
			throw new IllegalArgumentException("destino");
		}
	}

	void viajar() throws Exception {
		barco.viajar(destino);
	}

}