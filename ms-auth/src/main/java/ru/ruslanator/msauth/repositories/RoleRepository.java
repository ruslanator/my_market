package ru.ruslanator.msauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ruslanator.msauth.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
