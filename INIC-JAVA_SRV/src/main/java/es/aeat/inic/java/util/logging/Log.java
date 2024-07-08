package es.aeat.inic.java.util.logging;

import java.io.OutputStream;
import java.util.function.Function;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class Log {

	public static Logger newLogger(OutputStream outputStream, Function<LogRecord, String> formatter) throws Exception {
		Logger logger = Logger.getAnonymousLogger();
		configure(logger, outputStream, formatter);
		return logger;
	}
	
	public static void configure(Logger logger, OutputStream outputStream, Function<LogRecord, String> formatter) throws Exception {
		configure(logger, outputStream, formatter == null? null : new Formatter() {
			final String lineSeparator = System.getProperty("line.separator");
			@Override
			public String format(LogRecord record) {
				return formatter.apply(record) + lineSeparator;
			}
		});
	}
	
	public static void configure(Logger logger, OutputStream outputStream, Formatter formatter) throws Exception {
		for (Handler handler : logger.getHandlers()) {
			logger.removeHandler(handler);
		}
        var handler = new StreamHandler(outputStream, formatter) {
            @Override
            public synchronized void publish(final LogRecord record) {
                super.publish(record);
                flush();
            }
        };
        logger.addHandler(handler);
		logger.setUseParentHandlers(false);
	}
	
}