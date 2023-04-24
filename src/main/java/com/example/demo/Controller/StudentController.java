package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
@Controller
public class StudentController {
	
	@Autowired
	private StudentService ser;

	public StudentController(StudentService ser) {
		super();
		this.ser = ser;
	}

	@GetMapping("/students")
	public String ListStudents(Model model) {
		
		model.addAttribute("students",ser.getAll());
		return "students";
	}
	
	@GetMapping("/student/{id}")
	public String ListOfStudents(Model model,@PathVariable Long id) {
		Student s=ser.findById(id);
		model.addAttribute("student",s);
		return "student";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create student object to hold student form data
		Student student =new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		ser.insert(student);
		return "redirect:/students";
	}
	
//	@PutMapping("/update/{email}")
//	public String update (Model model,@PathVariable String email) {
//		Student s=ser.update(ser.findByEmail(email));
//		model.addAttribute("update",s);
//		return "update";
//	}
	@GetMapping("/students/edit/{id}")
	public String editform(@PathVariable Long id ,Model model) {
		model.addAttribute("student",ser.findById(id));
		return "edit_student";
	}
	
	@PostMapping("/studets/{id}")
	public String updateStudent(@PathVariable Long id ,@ModelAttribute("student") Student student,Model model) {
		
		// Get Student from Data Base
		Student current =ser.findById(id);
//		current.setId(id);
		current.setFirstName(student.getFirstName());
		current.setLastName(student.getLastName());
		current.setEmail(student.getEmail());
		
		//Save The Update
		ser.update(current);
		
		return "redirect:/students";
	}
}
