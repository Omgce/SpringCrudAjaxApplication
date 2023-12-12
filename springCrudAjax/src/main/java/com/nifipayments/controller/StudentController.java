package com.nifipayments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nifipayments.model.Student;
import com.nifipayments.model.repository.StudentRepository;
import com.nifipayments.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentService service;

	private StudentRepository studentRepository;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student std) {
		service.save(std);
		return "{\"status\":\"success\"}";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Student> listStudents() {
		List<Student> liststudent = service.listAll();
		return liststudent;
	}

	@RequestMapping(value = "/get/{id}")
	public Student getStudentPage(@PathVariable(name = "id") Long id) {
		return service.getid(id);
	}

	@RequestMapping(value = "/edit/{id}")
	public String updateStudent(@PathVariable("id") Long id, Student student) {
		// Student getid = service.getid(id);
		student.setId(id);
		service.save(student);
		return "{\"status\":\"success\"}";
	}

	@RequestMapping("/delete/{id}")
	public String deletestudent(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return "{\"status\":\"success\"}";
	}

}
