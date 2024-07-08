package org.example.vehiculos;

import java.io.OutputStream;

public class Motocicleta extends VehiculoConRuedas {

	public Motocicleta(String nombre) throws Exception {
		this(nombre, null);
	}
	
	public Motocicleta(String nombre, OutputStream output) throws Exception {
		super(nombre, 2, output);
	}

	@Override
	protected void preparar() throws Exception {
		super.preparar();
		logger.info("comprobando los frenos...");
	}

}