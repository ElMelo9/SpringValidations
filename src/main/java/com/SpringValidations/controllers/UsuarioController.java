package com.SpringValidations.controllers;

import com.SpringValidations.controllers.dto.UsuarioDTO;
import com.SpringValidations.entities.UsuarioEntity;
import com.SpringValidations.services.UsuarioService;
import com.SpringValidations.services.mappers.UsuarioMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;
    @Autowired
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService,UsuarioMapper usuarioMapper){
        this.usuarioService = usuarioService;
        this.usuarioMapper  = usuarioMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<UsuarioDTO> save(@RequestBody @Valid  UsuarioDTO usuarioDTO) {
            UsuarioEntity usuarioEntity = this.usuarioService.save(usuarioDTO);
            UsuarioDTO responseDTO = this.usuarioMapper.toDto(usuarioEntity);
            return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UsuarioDTO>> getAll(){
        List<UsuarioEntity> usuarioEntityList = this.usuarioService.getAll();
        List<UsuarioDTO> usuariosDTO = this.usuarioMapper.toListDto(usuarioEntityList);
        return ResponseEntity.ok(usuariosDTO);
    }
}
