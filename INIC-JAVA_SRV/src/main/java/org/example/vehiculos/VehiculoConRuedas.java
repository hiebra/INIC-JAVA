package org.example.vehiculos;

import java.io.OutputStream;

public abstract class VehiculoConRuedas extends Vehiculo {

	private final int ruedas;

	protected VehiculoConRuedas(String nombre, int ruedas) {
		this(nombre, ruedas, null);
	}
	
	protected VehiculoConRuedas(String nombre, int ruedas, OutputStream output) {
		super(nombre, output);
		this.ruedas = ruedas;
	}

	@Override
	protected void preparar() {
		for (int i = 0; i < ruedas; i++) {
			logger.info("comprobando el neumático %d...".formatted(i + 1));
		}
	}

}