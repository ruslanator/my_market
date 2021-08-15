package ru.ruslanator.msauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ruslanator.msauth.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
