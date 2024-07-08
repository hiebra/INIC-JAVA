package org.example.api.vehiculos;

public interface VehiculoSrv {

	VehiculoBean getVehiculoBean(TipoVehiculo tipo, String nombre);
	
	void viajar(VehiculoBean vehiculo, String destino);
	
}
