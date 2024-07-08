package org.example.api;

@FunctionalInterface
public interface Procedure extends Function<Void> {

	void run() throws Exception;
	
	@Override
	default Void call() throws Exception {
		run();
		return null;
	}
	
}
