package es.aeat.inic.java.vehiculos;

import java.io.OutputStream;

public class Coche extends VehiculoConRuedas {
	
	public Coche(String nombre) {
		this(nombre, null);
	}
	
	public Coche(String nombre, OutputStream output) {
		super(nombre, 4, output);
	}
	
	@Override
	protected void preparar() {
		super.preparar();
		logger.info("comprobando la rueda de repuesto...");
	}

}