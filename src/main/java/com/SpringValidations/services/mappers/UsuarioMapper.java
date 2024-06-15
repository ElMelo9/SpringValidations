package com.SpringValidations.services.mappers;

import com.SpringValidations.controllers.dto.RolDTO;
import com.SpringValidations.controllers.dto.UsuarioDTO;
import com.SpringValidations.entities.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDto(UsuarioEntity usuarioEntity){

        if (usuarioEntity==null){
            return null;
        }

        RolDTO rolDTO = RolDTO.builder()
                .nombre(usuarioEntity.getRol().getNombre())
                .build();

        return UsuarioDTO.builder()
                .nombre(usuarioEntity.getNombre())
                .login(usuarioEntity.getLogin())
                .pwd(usuarioEntity.getPwd())
                .rol(rolDTO)
                .build();

    }

    public List<UsuarioDTO> toListDto(List<UsuarioEntity> usuarioEntityList){

        if (usuarioEntityList.isEmpty()){
            return null;

        }
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        for (UsuarioEntity usuarioEntity:usuarioEntityList) {
            RolDTO rolDTO = RolDTO.builder()
                    .nombre(usuarioEntity.getRol().getNombre())
                    .build();

           UsuarioDTO usuarioDTO =  UsuarioDTO.builder()
                    .nombre(usuarioEntity.getNombre())
                    .login(usuarioEntity.getLogin())
                    .pwd(usuarioEntity.getPwd())
                    .rol(rolDTO)
                    .build();

           usuarioDTOS.add(usuarioDTO);
        }
    return usuarioDTOS;
    }

}
