package org.websparrow.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.websparrow.dao.StudentDao;
import org.websparrow.model.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao stuDao;

	@RequestMapping(value = "/fetch")
	public ModelAndView listStudent(ModelAndView model) throws IOException {

		List<Student> listStu = stuDao.stuList();

		model.addObject("listStu", listStu);
		model.setViewName("index");

		return model;
	}

	@RequestMapping(value = "/getStudentPhoto/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");

		Blob ph = stuDao.getPhotoById(id);

		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
}
