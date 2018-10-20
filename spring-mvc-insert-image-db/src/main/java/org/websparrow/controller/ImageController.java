package org.websparrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.websparrow.dao.ImageDao;

@Controller
public class ImageController {

	@Autowired
	ImageDao imageDao;

	@RequestMapping(value = "/InsertImage", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("name") String name, @RequestParam("age") Integer age,
			@RequestParam("photo") MultipartFile photo) {

		try {
			imageDao.inserRecords(name, age, photo);

			return new ModelAndView("index", "msg", "Records succesfully inserted into database.");

		} catch (Exception e) {
			return new ModelAndView("index", "msg", "Error: " + e.getMessage());
		}
	}
}
