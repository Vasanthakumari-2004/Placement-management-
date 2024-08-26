package com.tnsif.pm.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    public List<Student> listAll()
    {
        return studentRepository.findAll();
    }
    
    public Student get(Long id)
    {
        return studentRepository.findById(id).get();
    }
    
    public void save(Student student) 
    {
       studentRepository.save(student);
    }
   
    public void delete(Long id) 
    {
        studentRepository.deleteById(id);
    }
}


	
	
	


