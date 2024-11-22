package com.P2.CBS.service;

import com.P2.CBS.model.Role;
import com.P2.CBS.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }
}
