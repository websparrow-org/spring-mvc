package org.websparrow.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.websparrow.model.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemp;

	public StudentDaoImpl(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Student> stuList() {

		List<Student> list = jdbcTemp.query("SELECT * FROM student", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();

				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));

				return stu;
			}
		});

		return list;
	}

	@Override
	public Blob getPhotoById(int id) {

		String query = "select photo from student where id=?";

		Blob photo = jdbcTemp.queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}

}
