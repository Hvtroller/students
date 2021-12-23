package com.hvtroller.students.service;

import com.hvtroller.students.model.Role;
import com.hvtroller.students.model.Student;
import com.hvtroller.students.repository.RoleRepository;
import com.hvtroller.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    private final StudentRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public StudentService(StudentRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void saveStudent(Student student) {
        userRepository.save(student);
    }

    public Student getStudent(Long id) {
        if(userRepository.existsById(id)) {
            return userRepository.getById(id);
        } else {
            throw new NoSuchElementException("Student id " + id + " not exist");
        }
    }

    public List<Student> getAllStudents() {
        return userRepository.findByRole(roleRepository.findByName("STUDENT"));
    }

    public void deleteStudent(Long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Student id " + id + " not exist");
        }
    }

    public void addRoleToUser(String email, String role) {
        Student student = userRepository.findByEmail(email);
        Role r = roleRepository.findByName(role);
        student.setRole(r);
        userRepository.save(student);
    }
}
