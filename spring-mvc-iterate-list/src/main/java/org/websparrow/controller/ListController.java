package org.websparrow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAction() {

		List<String> empList = new ArrayList<>();
		empList.add("Atul");
		empList.add("Abhinav");
		empList.add("Prince");
		empList.add("Gaurav");

		ModelAndView mv = new ModelAndView();

		mv.setViewName("index");
		mv.addObject("empList", empList);

		return mv;

	}
}
