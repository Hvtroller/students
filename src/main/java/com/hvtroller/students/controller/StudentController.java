package com.hvtroller.students.controller;

import com.hvtroller.students.model.Student;
import com.hvtroller.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
public class StudentController {

    private final StudentService userService;

    @Autowired
    public StudentController(StudentService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String index(){
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("students", userService.getAllStudents());
        return "student/students";
    }

    @GetMapping("/students/new")
    public String getAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/student_add_form";
    }

    @PostMapping("/students/new")
    public String addStudent(@ModelAttribute("student") Student student, Model model) {

        if(student.getEmail() == null || student.getLastName() == null || student.getFirstName() == null) {
            model.addAttribute("error", "Miss parameter");
            return "student/student_add_form";
        }
        if(student.getEmail().isBlank() || student.getFirstName().isBlank() || student.getLastName().isBlank()){
            model.addAttribute("error", "All field need to be filled");
            return "student/student_add_form";
        }
        userService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String getEditForm(Model model, @PathVariable("id") Long id) {
        Student student = userService.getStudent(id);
        model.addAttribute("student", student);
        return "student/student_edit_form";
    }

    @PostMapping("/students/edit/{id}")
    public String editStudent(@ModelAttribute("student") Student student, Model model) {
        if(student.getEmail() == null || student.getLastName() == null || student.getFirstName() == null) {
            model.addAttribute("error", "Miss parameter");
            return "student/student_edit_form";
        }
        if(student.getEmail().isBlank() || student.getFirstName().isBlank() || student.getLastName().isBlank()){
            model.addAttribute("error", "All field need to be filled");
            return "student/student_edit_form";
        }
        try{
            userService.getStudent(student.getId());
            userService.saveStudent(student);
            return "redirect:/students";
        } catch (NoSuchElementException ex){
            model.addAttribute("error", "No such student");
            return "student/student_edit_form";
        }


    }

    @RequestMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        userService.deleteStudent(id);
        return "redirect:/students";
    }
}
