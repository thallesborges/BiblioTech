package dev.thallesborges.BiblioTech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "autores")
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nacionalidade;

    @ManyToMany(mappedBy = "autores", fetch = FetchType.LAZY)
    private Set<LivroEntity> livros = new HashSet<>();
}
