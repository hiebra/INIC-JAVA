package org.example.api.util.logging;

import java.io.OutputStream;
import java.util.function.Function;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public interface LogSrv {

	void configure(Logger logger, OutputStream outputStream, Function<LogRecord, String> formatter);
	
	default void configure(Logger logger, OutputStream outputStream) {
		configure(logger, outputStream, null);
	}
	
}
