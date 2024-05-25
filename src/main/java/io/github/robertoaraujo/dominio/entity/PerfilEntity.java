package io.github.robertoaraujo.dominio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "perfil")
//@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class PerfilEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nome" )
    private String nome;

    @ManyToMany(mappedBy = "papeis", fetch = FetchType.EAGER)
    private Set<UsuarioEntity> usuarios = new HashSet<>();

}
