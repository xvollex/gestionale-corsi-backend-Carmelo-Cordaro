package it.corso.service;

import java.util.List;

import it.corso.dto.AddCourdeDTO;
import it.corso.dto.CorsoDTO;
import it.corso.dto.UserRegisterDTO;

public interface CorsoService 
{
	List<CorsoDTO> getCourses();
	void addCourse(AddCourdeDTO course);
	void deleteCourseById(int id);
}
