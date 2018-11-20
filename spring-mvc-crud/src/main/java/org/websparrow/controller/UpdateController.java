package org.websparrow.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.websparrow.dao.StudentDao;
import org.websparrow.model.Student;

@Controller
public class UpdateController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/update/{studentId}")
	public ModelAndView findStudentById(ModelAndView model, @PathVariable("studentId") int studentId)
			throws IOException {

		List<Student> listStudent = studentDao.findStudentById(studentId);
		model.addObject("listStudent", listStudent);
		model.setViewName("update");

		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("course") String course, ModelAndView mv) {

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setCourse(course);

		int counter = studentDao.update(student);

		if (counter > 0) {
			mv.addObject("msg", "Student records updated against student id: " + student.getId());
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("update");

		return mv;
	}
}
