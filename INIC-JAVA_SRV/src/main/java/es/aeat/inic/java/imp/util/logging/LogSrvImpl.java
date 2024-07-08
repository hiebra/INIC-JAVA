package es.aeat.inic.java.imp.util.logging;

import java.io.OutputStream;
import java.util.function.Function;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.google.auto.service.AutoService;

import es.aeat.inic.java.api.util.logging.LogSrv;
import es.aeat.inic.java.util.logging.Log;

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