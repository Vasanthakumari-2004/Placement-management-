package com.tnsif.pm.Student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController


public class StudentController
{
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/students")
    public List<Student>list()
 {
        return studentService.listAll();

    }
    
    @GetMapping("/students/{id}")
    public ResponseEntity<Student>get(@PathVariable Long id)
    {
    	try
    	{
    		Student student= studentService.get(id);
    		return new ResponseEntity<Student>(student,HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    	
        return new  ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    	}

    }
    
    @PostMapping("/students")
    public void add(@RequestBody Student students)
    {
    	
         studentService.save(students);
    }
    
    @PutMapping("/students/{id}")
    public ResponseEntity<?> update(@RequestBody Student student,@PathVariable Long id)
    {
    	try {
    	       Student existStudent = studentService.get(id);
    	       if (existStudent != null) {
    	           student.setId(id); 
    	           studentService.save(student);
    	           return new ResponseEntity<Student>(student, HttpStatus.OK);
    	       } 
    	       else
    	       {
    	           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	       }
    	   } catch (Exception e) {
    	       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	   }

    }
    
    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable Long id)
    {
        studentService.delete(id);
    }
}

