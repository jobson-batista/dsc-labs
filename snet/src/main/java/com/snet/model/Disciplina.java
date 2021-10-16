package com.snet.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private int likes;
    private double nota;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_disciplina")
    private List<Comentario> comentarios;
}
