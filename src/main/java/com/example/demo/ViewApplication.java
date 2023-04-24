package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
@SpringBootApplication
public class ViewApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ViewApplication.class, args);
	}
	@Autowired
	StudentService ser;
	@Override
	public void run(String... args) throws Exception {
		
		if(ser.count()==0) {

		Student s = new Student("Mohammed", "Zayed", "Mohamed@gmail.com");
		ser.insert(s);
		Student s1 = new Student("Bahaa", "Zayed", "Bahaa@gmail.com");
		ser.insert(s1);
		Student s2 = new Student("Fisal", "Zayed", "Fisal@gmail.com");
		ser.insert(s2);
		Student s3 = new Student("Ahmed", "Zayed", "Ahmed@gmail.com");
		ser.insert(s3);	
		}
	}

}
