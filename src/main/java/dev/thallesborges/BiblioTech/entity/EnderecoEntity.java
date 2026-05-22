package dev.thallesborges.BiblioTech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name= "enderecos")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false, length = 200)
    private String logradouro;

    @NotBlank
    @Size(max = 10)
    @Column(nullable = false, length = 10)
    private String numero;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String bairro;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String cidade;

    @NotBlank
    @Size(max = 2)
    @Column(nullable = false, length = 2)
    private String estado;

    @NotBlank
    @Size(max = 8)
    @Column(nullable = false, length = 8)
    private String cep;

    @OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY)
    private List<UsuarioEntity> moradores = new ArrayList<>();
}
