package com.ibetar.employeesdbcontrol.persistence.repository;

import com.ibetar.employeesdbcontrol.persistence.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
