package org.example.vehiculos;

import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.example.util.logging.Log;

public class App {

	public static final Logger logger = Logger.getGlobal();

	static {
		try {
			Log.configure(logger, System.out, App::message);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static String message(LogRecord record) {
		return "[%s] %s".formatted(record.getLevel(), record.getMessage());
	}
	
}