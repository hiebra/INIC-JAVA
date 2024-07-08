package org.example.app.web.vehiculos;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.vehiculos.Barco;

class ViajeEnBarcoPost {

	OutputStream out;
	String nombre;
	String destino;
	boolean tieneVela;
	Barco barco;
	
	ViajeEnBarcoPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		nombre = request.getParameter("nombre");
		destino = request.getParameter("destino");
		tieneVela = request.getParameter("tiene-vela") != null;
		validarParametros();
		out = response.getOutputStream();
		setBarco();
		viajar();
	}
	
	void setBarco() {
		barco = new Barco(nombre, tieneVela, out);
	}
	
	void validarParametros() {
		if (nombre.equals(null)) {
			throw new IllegalArgumentException("nombre");
		}
		if (destino.equals(null)) {
			throw new IllegalArgumentException("destino");
		}
	}

	void viajar() {
		barco.viajar(destino);
	}

}