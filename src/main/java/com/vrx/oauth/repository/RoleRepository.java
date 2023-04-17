package com.vrx.oauth.repository;

import com.vrx.oauth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByRole(String role);
}
