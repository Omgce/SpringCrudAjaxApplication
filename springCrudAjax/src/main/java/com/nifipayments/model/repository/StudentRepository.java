package com.nifipayments.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nifipayments.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
