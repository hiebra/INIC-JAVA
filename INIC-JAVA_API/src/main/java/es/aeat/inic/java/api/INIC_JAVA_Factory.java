package es.aeat.inic.java.api;

import es.aeat.inic.java.api.util.logging.LogSrv;
import es.aeat.inic.java.api.vehiculos.BarcoSrv;
import es.aeat.inic.java.api.vehiculos.VehiculoSrv;

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