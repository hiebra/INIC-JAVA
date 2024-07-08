package org.example.util.logging;

import java.io.OutputStream;
import java.util.function.Function;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import org.jspecify.annotations.Nullable;

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
	
	public static void configure(Logger logger, OutputStream outputStream, @Nullable Formatter formatter) throws Exception {
		for (Handler handler : logger.getHandlers()) {
			logger.removeHandler(handler);
		}
        var handler = new StreamHandler(outputStream, new SimpleFormatter()) {
            @Override
            public synchronized void publish(final LogRecord record) {
                super.publish(record);
                flush();
            }
        };
        if (formatter != null) {
            handler.setFormatter(formatter);
        }
        logger.addHandler(handler);
		logger.setUseParentHandlers(false);
	}
	
}