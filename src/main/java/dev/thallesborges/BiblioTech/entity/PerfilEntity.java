package dev.thallesborges.BiblioTech.entity;

import dev.thallesborges.BiblioTech.enums.UsuarioPerfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "perfis")
public class PerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "nome", nullable = false, unique = true, length = 30)
    private UsuarioPerfil perfil;

    @ManyToMany(mappedBy = "perfis", fetch = FetchType.LAZY)
    private Set<UsuarioEntity> usuarios = new HashSet<>();
}
