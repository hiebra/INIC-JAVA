package org.example.app.web.vehiculos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViajeEnBarcoGet {

	public ViajeEnBarcoGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		var html = getClass().getResourceAsStream("ViajeEnBarco.html");
		html.transferTo(response.getOutputStream());
	}

}
