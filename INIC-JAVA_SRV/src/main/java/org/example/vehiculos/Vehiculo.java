package org.example.vehiculos;

import java.io.OutputStream;
import java.util.logging.Logger;

import org.example.api.vehiculos.VehiculoBean;
import org.example.util.logging.Log;

public abstract class Vehiculo implements VehiculoBean {

	public final String nombre;
	protected final Logger logger;

	protected Vehiculo(String nombre, OutputStream out) throws Exception {
		if (out == null) {
			logger = App.logger;
		} else {
			logger = Logger.getAnonymousLogger();
			Log.configure(logger, System.out, App::message);
		}
		this.nombre = nombre;
	}
	
	protected Vehiculo(String nombre) throws Exception {
		this(nombre, null);
	}

	protected abstract void preparar() throws Exception;

	public void viajar(String destino) throws Exception {
		logger.info("preparando %s para el viaje...".formatted(nombre));
		preparar();
		logger.info("%s está OK. Viajando a %s...".formatted(nombre, destino));
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}
	
}