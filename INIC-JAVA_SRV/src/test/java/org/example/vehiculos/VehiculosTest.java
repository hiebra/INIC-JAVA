package org.example.vehiculos;

import static es.aeat.inic.java.api.vehiculos.TipoVehiculo.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.aeat.inic.java.api.INIC_JAVA_Factory;
import es.aeat.inic.java.api.vehiculos.BarcoSrv;
import es.aeat.inic.java.api.vehiculos.BarcoTrait;
import es.aeat.inic.java.api.vehiculos.VehiculoTrait;
import es.aeat.inic.java.vehiculos.Barco;
import es.aeat.inic.java.vehiculos.Coche;
import es.aeat.inic.java.vehiculos.Motocicleta;

class VehiculosTest implements BarcoTrait, VehiculoTrait {

	static final String LINE_SEPARATOR = System.getProperty("line.separator"); 

	private static final String EXPECTED = """
			[INFO] preparando la furgo camperizada para el viaje...
			[INFO] comprobando el neumático 1...
			[INFO] comprobando el neumático 2...
			[INFO] comprobando el neumático 3...
			[INFO] comprobando el neumático 4...
			[INFO] comprobando la rueda de repuesto...
			[INFO] la furgo camperizada está OK. Viajando a Berlín...
			[INFO] preparando la moto del Dakar para el viaje...
			[INFO] comprobando el neumático 1...
			[INFO] comprobando el neumático 2...
			[INFO] comprobando los frenos...
			[INFO] la moto del Dakar está OK. Viajando a Los Monegros...
			[INFO] preparando el Optimist para el viaje...
			[INFO] comprobando el estado de la vela...
			[INFO] el Optimist está OK. Viajando a Cabo Verde...
						""";

	ByteArrayOutputStream out = new ByteArrayOutputStream();

	@BeforeAll
	static void beforeAll() {
		if (!LINE_SEPARATOR.equals("\n")) {
			System.setProperty("line.separator", "\n");
		}
	}
	
	@AfterAll
	static void afterAll() {
		if (!LINE_SEPARATOR.equals("\n")) {
			System.setProperty("line.separator", LINE_SEPARATOR);	
		}
	}
	
	@AfterEach
	void afterEach() {
		assertEquals(EXPECTED, new String(out.toByteArray()));		
	}

	@Test
	void classes() {
		var furgo = new Coche("la furgo camperizada", out);
		furgo.viajar("Berlín");
		var moto = new Motocicleta("la moto del Dakar", out);
		moto.viajar("Los Monegros");
		var velero = new Barco("el Optimist", true, out);
		velero.viajar("Cabo Verde");
	}

	@Test
	void traits() {
		var furgo = getVehiculoBean(COCHE, "la furgo camperizada", out);
		viajar(furgo, "Berlín");
		var moto = getVehiculoBean(MOTOCICLETA, "la moto del Dakar", out);
		viajar(moto, "Los Monegros");
		var velero = getBarcoBean("el Optimist", true, out);
		viajar(velero, "Cabo Verde");
	}

	@Test
	void services() {
		var vehiculos = INIC_JAVA_Factory.getVehiculoSrv();
		var furgo = vehiculos.getVehiculoBean(COCHE, "la furgo camperizada", out);
		vehiculos.viajar(furgo, "Berlín");
		var moto = vehiculos.getVehiculoBean(MOTOCICLETA, "la moto del Dakar", out);
		vehiculos.viajar(moto, "Los Monegros");
		BarcoSrv barcos = INIC_JAVA_Factory.getBarcoSrv();
		var velero = barcos.getBarcoBean("el Optimist", true, out);
		vehiculos.viajar(velero, "Cabo Verde");
	}
	
}