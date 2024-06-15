package com.SpringValidations.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RolEntity {
    @Id
    @Column(name = "id_rol")
    private Long id;
    @Column(name = "nombre_rol")
    private String nombre;
    @Column(name = "estado_rg_rol")
    private byte estadoRg;
    @Column(name = "fecha_rg")
    private Timestamp fechaRg;
    @Column(name = "fecha_md")
    private Timestamp fechaMd;

    //relacion de uno a muchos
    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private List<UsuarioEntity> usuarios;

}
