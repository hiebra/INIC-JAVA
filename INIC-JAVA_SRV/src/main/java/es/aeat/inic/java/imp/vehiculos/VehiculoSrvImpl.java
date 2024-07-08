package es.aeat.inic.java.imp.vehiculos;

import java.io.OutputStream;

import com.google.auto.service.AutoService;

import es.aeat.inic.java.api.vehiculos.TipoVehiculo;
import es.aeat.inic.java.api.vehiculos.VehiculoBean;
import es.aeat.inic.java.api.vehiculos.VehiculoSrv;
import es.aeat.inic.java.vehiculos.Barco;
import es.aeat.inic.java.vehiculos.Coche;
import es.aeat.inic.java.vehiculos.Motocicleta;
import es.aeat.inic.java.vehiculos.Vehiculo;

@AutoService(VehiculoSrv.class)
public class VehiculoSrvImpl implements VehiculoSrv {

	@Override
	public VehiculoBean getVehiculoBean(TipoVehiculo tipo, String nombre) {
		try {
			if (tipo == TipoVehiculo.BARCO) {
				 return new Barco(nombre);
			} else if (tipo == TipoVehiculo.COCHE) {
				return new Coche(nombre);
			} else if (tipo == TipoVehiculo.MOTOCICLETA) {
				return new Motocicleta(nombre);
			} else {
				throw new IllegalArgumentException("Valor no esperado del parámetro 'tipo': %s".formatted(tipo));
			}	
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	@Override
	public VehiculoBean getVehiculoBean(TipoVehiculo tipo, String nombre, OutputStream output) {
		try {
			if (tipo == TipoVehiculo.COCHE) {
				return new Coche(nombre, output);
			} else if (tipo == TipoVehiculo.MOTOCICLETA) {
				return new Motocicleta(nombre, output);
			} else {
				throw new IllegalArgumentException("Valor no esperado del parámetro 'tipo': %s".formatted(tipo));
			}	
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void viajar(VehiculoBean vehiculo, String destino) {
		if (vehiculo instanceof Vehiculo backend) {
			try {
				backend.viajar(destino);
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		} else {
			throw new IllegalArgumentException("El parámetro 'vehiculo' no es instancia de %s".formatted(Vehiculo.class));
		}
	}

}