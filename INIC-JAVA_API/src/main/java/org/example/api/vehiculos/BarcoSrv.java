package org.example.api.vehiculos;

import java.io.OutputStream;

public interface BarcoSrv {

	BarcoBean getBarcoBean(String string, boolean tieneVela, OutputStream out);
	BarcoBean getBarcoBean(String nombre, boolean tieneVela);
	BarcoBean getBarcoBean(String nombre);
	
	void viajar(BarcoBean vehiculo, String destino);
	
}
