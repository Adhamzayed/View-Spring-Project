package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRep;

@Service
public class StudentService {

	@Autowired
	private StudentRep rep;

	public Long count() {
		return rep.count();
	}

	public List<Student> getAll() {
		return rep.findAll();
	}

	public Student findById(Long id) {
		return rep.findById(id).get();
	}

	public Student insert(Student stud) {
		return rep.save(stud);
	}

	public Student update(Student student) {
		return rep.save(student);
	}

	public void deleteById(Long id) {
		rep.deleteById(id);
	}

	public void deleteAll() {
		rep.deleteAll();
	}
//
//	public Student findByEmail(String email) {
//		return rep.findByEmail(email);
//	}
	
	public Student updateStudent(Student student) {
		return rep.save(student);
	}
	
}
