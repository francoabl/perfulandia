package com.perfulandia.cl.perfulandia.repository;

import com.perfulandia.cl.perfulandia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
