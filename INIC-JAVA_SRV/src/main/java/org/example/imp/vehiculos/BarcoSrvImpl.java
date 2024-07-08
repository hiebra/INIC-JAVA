package org.example.imp.vehiculos;

import org.example.api.vehiculos.BarcoBean;
import org.example.api.vehiculos.BarcoSrv;
import org.example.vehiculos.Barco;
import org.example.vehiculos.Vehiculo;

import com.google.auto.service.AutoService;

@AutoService(BarcoSrv.class)
public class BarcoSrvImpl implements BarcoSrv {

	@Override
	public BarcoBean getBarcoBean(String nombre) {
		try {
			return new Barco(nombre);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	@Override
	public BarcoBean getBarcoBean(String nombre, boolean vela) {
		try {
			return new Barco(nombre, vela);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void viajar(BarcoBean barco, String destino) {
		if (barco instanceof Barco backend) {
			try {
				backend.viajar(destino);
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		} else {
			throw new IllegalArgumentException("El parámetro 'barco' no es instancia de %s".formatted(Vehiculo.class));
		}
	}

}