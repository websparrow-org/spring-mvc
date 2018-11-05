package org.websparrow.dao;

import java.sql.Blob;
import java.util.List;

import org.websparrow.model.Student;

public interface StudentDao {

	public List<Student> stuList();
	
	public Blob getPhotoById(int id);

}
