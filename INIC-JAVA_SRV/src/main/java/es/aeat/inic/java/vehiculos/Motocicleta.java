package es.aeat.inic.java.vehiculos;

import java.io.OutputStream;

public class Motocicleta extends VehiculoConRuedas {

	public Motocicleta(String nombre) {
		this(nombre, null);
	}
	
	public Motocicleta(String nombre, OutputStream output) {
		super(nombre, 2, output);
	}

	@Override
	protected void preparar() {
		super.preparar();
		logger.info("comprobando los frenos...");
	}

}