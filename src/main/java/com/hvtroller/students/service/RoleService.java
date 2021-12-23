package com.hvtroller.students.service;

import com.hvtroller.students.model.Role;
import com.hvtroller.students.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void saveRole(Role role){
        roleRepository.save(role);
    }


}
