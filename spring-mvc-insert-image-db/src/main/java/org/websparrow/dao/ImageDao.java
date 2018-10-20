package org.websparrow.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

public class ImageDao {

	private JdbcTemplate jdbcTemplate;

	public ImageDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int inserRecords(String name, Integer age, MultipartFile photo) throws IOException {

		byte[] photoBytes = photo.getBytes();

		String sql = "INSERT INTO STUDENT(NAME,AGE,PHOTO) VALUES (?,?,?)";

		return jdbcTemplate.update(sql, new Object[] { name, age, photoBytes });
	}
}
