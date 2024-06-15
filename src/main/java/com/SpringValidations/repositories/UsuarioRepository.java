package com.SpringValidations.repositories;

import com.SpringValidations.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends CrudRepository<UsuarioEntity,Long> {

}
