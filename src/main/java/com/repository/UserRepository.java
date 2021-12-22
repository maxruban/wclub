package com.repository;

import com.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    @EntityGraph(attributePaths = {"addresses", "roles", "contacts"})   // allow to show which collection we can retrieve by EAGER
    User findById(int id);

    User findByLogin(String login);
}
