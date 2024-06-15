package com.SpringValidations.repositories;

import com.SpringValidations.entities.RolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<RolEntity,Long> {

    RolEntity findBynombre(String nombre);
}
