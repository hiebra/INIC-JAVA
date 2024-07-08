package org.example.api;

@FunctionalInterface
public interface Function<T> {

	T call() throws Exception;
	
}
