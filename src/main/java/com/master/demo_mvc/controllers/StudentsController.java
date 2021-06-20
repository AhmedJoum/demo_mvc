package com.master.demo_mvc.controllers;

import java.util.List;

import com.master.demo_mvc.dal.Student;
import com.master.demo_mvc.dal.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/students")
public class StudentsController {
  @Autowired
  private StudentRepository studentRepository;


  @GetMapping("/")
	public String viewHomePage(Model model) {
    List<Student> listStudents = (List<Student>) studentRepository.findAll(); 
    model.addAttribute("listStudents", listStudents);
		return "index1";		
	}

  @GetMapping("/addForm")
  public String showAddForm(Model model) {
    Student student = new Student();
    model.addAttribute("student", student);
    return "new_student";
  }

  @PostMapping(path = "/save")
  public String add(@ModelAttribute("student") Student student) {
    studentRepository.save(student);
    return "redirect:/students/";
  }

  @GetMapping("/updateForm/{id}")
  public String showUpdateForm(@PathVariable ( value = "id") Integer id, Model model){
    Student student =  studentRepository.findById(id).get();
    model.addAttribute("student", student); 
    return "update_student";
  }

  @GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable (value = "id") Integer id) {
		
		this.studentRepository.deleteById(id);
		return "redirect:/students/";
	}
 

}
