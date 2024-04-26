package com.onlyjoon.tddstudy.repository;

import com.onlyjoon.tddstudy.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
