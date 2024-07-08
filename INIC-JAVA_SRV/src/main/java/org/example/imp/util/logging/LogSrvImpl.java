package org.example.imp.util.logging;

import java.io.OutputStream;
import java.util.function.Function;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.example.api.util.logging.LogSrv;
import org.example.util.logging.Log;

import com.google.auto.service.AutoService;

@AutoService(LogSrv.class)
public class LogSrvImpl implements LogSrv {

	@Override
	public void configure(Logger logger, OutputStream outputStream, Function<LogRecord, String> formatter) {
		try {
			Log.configure(logger, outputStream, formatter);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
}