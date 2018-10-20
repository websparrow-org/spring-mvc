package org.websparrow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/india")
public class HelloController {

	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	public ModelAndView namaste(@RequestParam("name") String name, @RequestParam("age") int age) {

		ModelAndView model = new ModelAndView();
		model.addObject("data", "President name:" + name + " age:" + age);
		model.setViewName("index");

		return model;
	}

	@RequestMapping(value = "/welcome/{firstName}/{lastName}")
	public ModelAndView welcomeBack(@PathVariable("firstName") String first, @PathVariable("lastName") String last) {

		ModelAndView model = new ModelAndView();
		model.addObject("data", "Welcome Mr." + first + " " + last);
		model.setViewName("index");

		return model;
	}

}
