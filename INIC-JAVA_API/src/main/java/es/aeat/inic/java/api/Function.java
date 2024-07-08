package es.aeat.inic.java.api;

@FunctionalInterface
public interface Function<T> {

	T call() throws Exception;
	
}
