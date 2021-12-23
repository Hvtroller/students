package com.hvtroller.students;

import com.hvtroller.students.model.Role;
import com.hvtroller.students.model.Student;
import com.hvtroller.students.service.RoleService;
import com.hvtroller.students.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentService service, RoleService roleService) {
		return  args -> {
////			service.saveStudent(new Student("Tom","Holland","tom@gmail.com"));
////			service.saveStudent(new Student("Kevin","De Bruyen","kevin@gmail.com"));
////			service.saveStudent(new Student("Jack","Jellist","jack@gmail.com"));
////
////			roleService.saveRole(new Role("STUDENT"));
////			roleService.saveRole(new Role("TEACHER"));
////			roleService.saveRole(new Role("ADMIN"));
//
//			service.addRoleToUser("tom@gmail.com", "STUDENT");
//			service.addRoleToUser("kevin@gmail.com", "TEACHER");
//			service.addRoleToUser("jack@gmail.com", "ADMIN");
		};
	}
}
