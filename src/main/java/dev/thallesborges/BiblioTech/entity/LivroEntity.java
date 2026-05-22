package dev.thallesborges.BiblioTech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="livros")
public class LivroEntity extends AuditoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false)
    private String titulo;

    @NotBlank
    @Size(max = 13)
    @Column(nullable = false)
    private String isbn;

    @NotNull
    @PastOrPresent(message = "Ano de publicação não pode ser no futuro.")
    @Column(name = "ano_publicacao", nullable = false)
    private Year anoPublicacao;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String genero;

    @NotNull
    @PositiveOrZero
    @Column(name = "total_exemplares", nullable = false)
    private Integer totalExemplares;

    @NotNull
    @PositiveOrZero
    @Column(name = "exemplares_disponiveis", nullable = false)
    private Integer exemplaresDisponiveis;

    @NotBlank
    @Column(nullable = false)
    private Boolean ativo;

    @DecimalMin(value = "0.5")
    @DecimalMax(value = "5.0")
    private Double avaliacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "editora_id")
    private EditoraEntity editora;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "livros_autores",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )

    @NotEmpty
    private Set<AutorEntity> autores = new HashSet<>();
}
