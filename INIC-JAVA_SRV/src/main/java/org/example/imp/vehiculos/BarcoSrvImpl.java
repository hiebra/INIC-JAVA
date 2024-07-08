package org.example.imp.vehiculos;

import java.io.OutputStream;

import org.example.api.vehiculos.BarcoBean;
import org.example.api.vehiculos.BarcoSrv;
import org.example.vehiculos.Barco;
import org.example.vehiculos.Vehiculo;

import com.google.auto.service.AutoService;

@AutoService(BarcoSrv.class)
public class BarcoSrvImpl implements BarcoSrv {

	@Override
	public BarcoBean getBarcoBean(String nombre) {
		return new Barco(nombre);
	}
	
	@Override
	public BarcoBean getBarcoBean(String nombre, boolean tieneVela) {
		return new Barco(nombre, tieneVela);
	}
	
	@Override
	public BarcoBean getBarcoBean(String nombre, boolean vela, OutputStream output) {
		return new Barco(nombre, vela, output);
	}

	@Override
	public void viajar(BarcoBean barco, String destino) {
		if (barco instanceof Barco backend) {
			backend.viajar(destino);
		} else {
			throw new IllegalArgumentException("El parámetro 'barco' no es instancia de %s".formatted(Vehiculo.class));
		}
	}

}