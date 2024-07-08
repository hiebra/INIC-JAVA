package org.example.vehiculos;

import static org.example.api.vehiculos.TipoVehiculo.*;
import static org.example.vehiculos.App.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;

import org.example.api.INIC_JAVA_Factory;
import org.example.api.vehiculos.BarcoTrait;
import org.example.api.vehiculos.VehiculoTrait;
import org.example.util.logging.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehiculosTest implements BarcoTrait, VehiculoTrait {

	static final String lineSeparator = System.getProperty("line.separator"); 

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

	ByteArrayOutputStream out;
	
	@BeforeAll
	static void beforeAll() {
		if (!lineSeparator.equals("\n")) {
			System.setProperty("line.separator", "\n");	
		}
	}
	
//	@AfterAll
	static void afterAll() {
		if (!lineSeparator.equals("\n")) {
			System.setProperty("line.separator", lineSeparator);	
		}
	}
	
	@BeforeEach
	void beforeEach() throws Exception {
		out = new ByteArrayOutputStream();
		Log.configure(logger, out, App::message);		
	}
	
	@AfterEach
	void afterEach() throws Exception {
		assertEquals(EXPECTED, new String(out.toByteArray()));		
	}

//	@Test
	void x() {
		logger.info("X");
		logger.info("Y");
	}
	
	@Test
	void classes() throws Exception {
		var furgo = new Coche("la furgo camperizada");
		furgo.viajar("Berlín");
		var moto = new Motocicleta("la moto del Dakar");
		moto.viajar("Los Monegros");
		var velero = new Barco("el Optimist", true);
		velero.viajar("Cabo Verde");
	}

//	@Test
	void services() {
		var vehiculos = INIC_JAVA_Factory.getVehiculoSrv();
		var furgo = vehiculos.getVehiculoBean(COCHE, "la furgo camperizada");
		vehiculos.viajar(furgo, "Berlín");
		var moto = vehiculos.getVehiculoBean(MOTOCICLETA, "la moto del Dakar");
		vehiculos.viajar(moto, "Los Monegros");
		var barcos = INIC_JAVA_Factory.getBarcoSrv();
		var velero = barcos.getBarcoBean("el Optimist", true);
		vehiculos.viajar(velero, "Cabo Verde");
	}

//	@Test
	void traits() {
		var furgo = getVehiculoBean(COCHE, "la furgo camperizada");
		viajar(furgo, "Berlín");
		var moto = getVehiculoBean(MOTOCICLETA, "la moto del Dakar");
		viajar(moto, "Los Monegros");
		var velero = getBarcoBean("el Optimist", true);
		viajar(velero, "Cabo Verde");
	}

}