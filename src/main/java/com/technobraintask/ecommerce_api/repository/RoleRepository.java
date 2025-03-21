package com.technobraintask.ecommerce_api.repository;

import com.technobraintask.ecommerce_api.models.Role;
import com.technobraintask.ecommerce_api.models.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleEnum name);
}
