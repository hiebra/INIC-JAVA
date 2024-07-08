package org.example.api.vehiculos;

import java.io.OutputStream;

import org.example.api.INIC_JAVA_Factory;

public interface BarcoTrait extends BarcoSrv {

	@Override
	default BarcoBean getBarcoBean(String nombre) {
		return getBarcoSrv().getBarcoBean(nombre);
	}
	
	@Override
	default BarcoBean getBarcoBean(String nombre, boolean tieneVela) {
		return getBarcoSrv().getBarcoBean(nombre, tieneVela);
	}
	
	@Override
	default BarcoBean getBarcoBean(String nombre, boolean tieneVela, OutputStream output) {
		return getBarcoSrv().getBarcoBean(nombre, tieneVela, output);
	}
	
	@Override
	default void viajar(BarcoBean vehiculo, String destino) {
		getBarcoSrv().viajar(vehiculo, destino);
	}
	
	default BarcoSrv getBarcoSrv() {
		return INIC_JAVA_Factory.getBarcoSrv();
	}
	
}
