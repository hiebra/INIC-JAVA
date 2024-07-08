package es.aeat.inic.java.vehiculos;

import java.io.OutputStream;

import es.aeat.inic.java.api.vehiculos.BarcoBean;

public class Barco extends Vehiculo implements BarcoBean {

	public final boolean tieneVela;
	
	public Barco(String nombre) {
		this(nombre, false);
	}
	
	public Barco(String nombre, boolean tieneVela) {
		this(nombre, false, null);
	}
	
	public Barco(String nombre, boolean tieneVela, OutputStream output) {
		super(nombre, output);
		this.tieneVela = tieneVela;
	}

	@Override
	protected void preparar() {
		if (tieneVela) {
			logger.info("comprobando el estado de la vela...");	
		}
	}

	@Override
	public boolean getTieneVela() {
		return tieneVela;
	}
	
}