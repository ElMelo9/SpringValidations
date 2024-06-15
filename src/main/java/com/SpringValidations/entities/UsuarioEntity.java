package com.SpringValidations.entities;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    @Column(name = "nombre_usuario")
    private String nombre;
    @Column(name = "login_usuario")
    private String login;
    @Column(name = "pwd_usuario")
    private String pwd;
    @Column(name = "fecha_ultlogin")
    private Timestamp fechaUltLogin;
    @Column(name = "fecha_rg", insertable = false, updatable = false,nullable = false, columnDefinition = "now()")
    private Timestamp fechaRg;
    @Column(name = "estado_rg_usuario",insertable = false, updatable = true, nullable = false, columnDefinition = "BYTEA DEFAULT 1")
    private byte estadoRg;
    @Column(name = "fecha_md")
    private Timestamp fechaMd;

    @ManyToOne(targetEntity = RolEntity.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private RolEntity rol;
}
