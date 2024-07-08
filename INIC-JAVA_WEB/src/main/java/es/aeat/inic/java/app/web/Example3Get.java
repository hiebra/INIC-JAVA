package es.aeat.inic.java.app.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Example3Get {
	
	static final ThreadLocal<Example3Get> STATE = new ThreadLocal<>();
	
	public PrintWriter out;
	
	static void init(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			var self = new Example3Get();
			STATE.set(self);
			self.out = response.getWriter();
			main();
		} finally {
			STATE.remove();
		}
	}
	
	static void main() throws Exception {
		var self = STATE.get();
		self.out.println("Hello, World!");
	}
	
}