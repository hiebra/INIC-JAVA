package org.example.api;

import java.util.Optional;
import java.util.ServiceLoader;

public class Service {

	public static <T> T get(Class<T> service) {
		Optional<T> first = ServiceLoader.load(service).findFirst();
		if (first.isPresent()) {
			return first.get();
		} else {
			throw new IllegalStateException("Servicio no encontrado: %s".formatted(service));
		}
	}

	public static <T> T evaluate(Function<T> code) {
		try {
			return code.call();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static void execute(Procedure code) {
		evaluate(() -> {
			code.run();
			return null;
		});
	}
	
}