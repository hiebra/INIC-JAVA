package es.aeat.inic.java.api.vehiculos;

import java.io.OutputStream;

public interface VehiculoSrv {

	VehiculoBean getVehiculoBean(TipoVehiculo tipo, String nombre);
	VehiculoBean getVehiculoBean(TipoVehiculo coche, String string, OutputStream out);
	
	void viajar(VehiculoBean vehiculo, String destino);

	
}
