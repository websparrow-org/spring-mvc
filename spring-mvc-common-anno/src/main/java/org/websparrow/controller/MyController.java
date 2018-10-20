package org.websparrow.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/new")
public class MyController {

	@RequestMapping(value = "/greet", method = RequestMethod.POST)
	public ModelAndView greet(@RequestParam("name") String name) {

		ModelAndView model = new ModelAndView();

		model.addObject("data", name);
		model.setViewName("index");

		return model;
	}

	@RequestMapping(value = "/welcome/{name}")
	public ModelAndView welcome(@PathVariable("name") String name) throws IOException {

		ModelAndView model = new ModelAndView();

		model.addObject("data", name);
		model.setViewName("index");

		return model;
	}
}
