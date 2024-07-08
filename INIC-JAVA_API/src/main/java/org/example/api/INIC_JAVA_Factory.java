package org.example.api;

import org.example.api.util.logging.LogSrv;
import org.example.api.vehiculos.BarcoSrv;
import org.example.api.vehiculos.VehiculoSrv;

public class INIC_JAVA_Factory {

	public static VehiculoSrv getVehiculoSrv() {
		return Service.get(VehiculoSrv.class);
	}
	
	public static BarcoSrv getBarcoSrv() {
		return Service.get(BarcoSrv.class);
	}
	
	public static LogSrv getLogSrv() {
		return Service.get(LogSrv.class);
	}

}