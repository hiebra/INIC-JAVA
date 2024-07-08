package org.example.app.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Example2Get {

	PrintWriter out;
	
	static void init(HttpServletRequest request, HttpServletResponse response) throws Exception {
		var self = new Example2Get();
		self.out = response.getWriter();
		main(self);
	}
	
	static void main(Example2Get self) throws Exception {
		self.out.println("Hello, World!");
	}
	
}