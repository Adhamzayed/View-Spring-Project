package com.example.demo.Another;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@RestController
@RequestMapping("/student")
public class AnotherController {

	@Autowired
	StudentService ser;
	
	@GetMapping("/all")
	public List<Student> All(){
		return ser.getAll();
	}
	
	@PostMapping("")
	public Student insert(@RequestBody Student st) {
		return ser.insert(st);
	}
	
//	@PutMapping("update/{email}")
//	public Student update(@PathVariable String email) {
//		return ser.findByEmail(email);
//	}
}
