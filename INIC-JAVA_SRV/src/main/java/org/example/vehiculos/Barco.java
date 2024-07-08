package org.example.vehiculos;

import java.io.OutputStream;

import org.example.api.vehiculos.BarcoBean;

public class Barco extends Vehiculo implements BarcoBean {

	public final boolean tieneVela;
	
	public Barco(String nombre) throws Exception {
		this(nombre, false);
	}
	
	public Barco(String nombre, boolean tieneVela) throws Exception {
		this(nombre, false, null);
	}
	
	public Barco(String nombre, boolean tieneVela, OutputStream output) throws Exception {
		super(nombre, output);
		this.tieneVela = tieneVela;
	}

	@Override
	protected void preparar() throws Exception {
		if (tieneVela) {
			logger.info("comprobando el estado de la vela...");	
		}
	}

	@Override
	public boolean getTieneVela() {
		return tieneVela;
	}
	
}