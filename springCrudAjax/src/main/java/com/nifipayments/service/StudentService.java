package com.nifipayments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nifipayments.model.Student;
import com.nifipayments.model.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	public List<Student> listAll() {
		return repo.findAll();
	}

	public void save(Student student) {
		repo.save(student);
	}

	public Student getid(Long id) {
		Student student = repo.findById(id).get();
		return student;
	}

	public Student get(Long id) {
		Student student = repo.findById(id).get();
		return student;
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

}
