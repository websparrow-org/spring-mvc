package org.websparrow.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.websparrow.dao.DbAccess;

public class DbController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		

		Map<String, String> map = new HashMap<String, String>();
		
		DbAccess db = new DbAccess();

		if (db.connect() != null) {
			map.put("msg", "Database connection established successfully.");

		} else {
			map.put("msg", "Failed to connect database.");

		}
		
		
		return new ModelAndView("index", map);

	}

}
