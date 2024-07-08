package org.example.api.vehiculos;

public interface BarcoSrv {

	BarcoBean getBarcoBean(String nombre, boolean vela);
	BarcoBean getBarcoBean(String nombre);
	
	void viajar(BarcoBean vehiculo, String destino);
	
}
