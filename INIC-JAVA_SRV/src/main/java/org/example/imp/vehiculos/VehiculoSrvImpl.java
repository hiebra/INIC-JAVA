package org.example.imp.vehiculos;

import java.io.OutputStream;

import org.example.api.vehiculos.TipoVehiculo;
import org.example.api.vehiculos.VehiculoBean;
import org.example.api.vehiculos.VehiculoSrv;
import org.example.vehiculos.Barco;
import org.example.vehiculos.Coche;
import org.example.vehiculos.Motocicleta;
import org.example.vehiculos.Vehiculo;

import com.google.auto.service.AutoService;

@AutoService(VehiculoSrv.class)
public class VehiculoSrvImpl implements VehiculoSrv {

	@Override
	public VehiculoBean getVehiculoBean(TipoVehiculo tipo, String nombre) {
		if (tipo == TipoVehiculo.BARCO) {
			return new Barco(nombre);
		} else if (tipo == TipoVehiculo.COCHE) {
			return new Coche(nombre);
		} else if (tipo == TipoVehiculo.MOTOCICLETA) {
			return new Motocicleta(nombre);
		} else {
			throw new IllegalArgumentException("Valor no esperado del parámetro 'tipo': %s".formatted(tipo));
		}
	}

	@Override
	public VehiculoBean getVehiculoBean(TipoVehiculo tipo, String nombre, OutputStream output) {
		if (tipo == TipoVehiculo.COCHE) {
			return new Coche(nombre, output);
		} else if (tipo == TipoVehiculo.MOTOCICLETA) {
			return new Motocicleta(nombre, output);
		} else {
			throw new IllegalArgumentException("Valor no esperado del parámetro 'tipo': %s".formatted(tipo));
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