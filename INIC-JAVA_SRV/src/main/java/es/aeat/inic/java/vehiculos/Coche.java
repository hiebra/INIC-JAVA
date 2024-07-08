package es.aeat.inic.java.vehiculos;

import java.io.OutputStream;

public class Coche extends VehiculoConRuedas {
	
	public Coche(String nombre) throws Exception {
		this(nombre, null);
	}
	
	public Coche(String nombre, OutputStream output) throws Exception {
		super(nombre, 4, output);
	}
	
	@Override
	protected void preparar() throws Exception {
		super.preparar();
		logger.info("comprobando la rueda de repuesto...");
	}

}