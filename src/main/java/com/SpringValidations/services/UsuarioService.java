package com.SpringValidations.services;

import com.SpringValidations.controllers.dto.UsuarioDTO;
import com.SpringValidations.entities.RolEntity;
import com.SpringValidations.entities.UsuarioEntity;
import com.SpringValidations.repositories.RolRepository;
import com.SpringValidations.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository,RolRepository rolRepository){
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public UsuarioEntity save(UsuarioDTO usuarioDTO){

        RolEntity rol = this.rolRepository.findBynombre(usuarioDTO.getRol().getNombre());

        if (rol==null){
            throw new RuntimeException("Rol no encontrado.");
        }

        UsuarioEntity usuarioEntity = UsuarioEntity.builder()
                .nombre(usuarioDTO.getNombre())
                .login(usuarioDTO.getLogin())
                .pwd(usuarioDTO.getPwd())
                .rol(rol)
                .build();
        return this.usuarioRepository.save(usuarioEntity);
    }

    public List<UsuarioEntity> getAll(){
        return (List<UsuarioEntity>) this.usuarioRepository.findAll();
    }

}
