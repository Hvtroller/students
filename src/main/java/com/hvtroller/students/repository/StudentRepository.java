package com.hvtroller.students.repository;

import com.hvtroller.students.model.Role;
import com.hvtroller.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByRole(Role role);
    Student findByEmail(String email);
}
