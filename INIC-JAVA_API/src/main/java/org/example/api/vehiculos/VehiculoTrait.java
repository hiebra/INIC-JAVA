package org.example.api.vehiculos;

import org.example.api.Service;

public interface VehiculoTrait extends VehiculoSrv {

	@Override
	default VehiculoBean getVehiculoBean(TipoVehiculo tipo, String nombre) {
		return getVehiculoSrv().getVehiculoBean(tipo, nombre);
	}
	
	@Override
	default void viajar(VehiculoBean vehiculo, String destino) {
		getVehiculoSrv().viajar(vehiculo, destino);
	}
	
	default VehiculoSrv getVehiculoSrv() {
		return Service.get(VehiculoSrv.class);
	}
	
}