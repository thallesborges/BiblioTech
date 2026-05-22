package dev.thallesborges.BiblioTech.entity;

import dev.thallesborges.BiblioTech.enums.UsuarioStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "usuarios")
public class UsuarioEntity extends AuditoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Size(max = 11)
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @NotBlank
    @Size(max = 100)
    @Email
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @NotBlank
    @Size(max = 15)
    @Column(nullable = false, length = 15)
    private String telefone;

    @NotNull
    @Size(max = 255)
    @Column(name = "senha_hash", nullable = false, length = 255)
    private String senhaHash;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private UsuarioStatus status = UsuarioStatus.ATIVO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuarios_perfis",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private Set<PerfilEntity> perfis = new HashSet<>();

}
