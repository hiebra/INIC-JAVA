package org.example.app.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Example1Get {

	PrintWriter out;
	
	Example1Get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		out = response.getWriter();
		main();
	}
	
	void main() throws Exception {
		out.println("Hello, World!");
	}
	
}