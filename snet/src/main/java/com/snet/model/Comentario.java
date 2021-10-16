package com.snet.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String autor;
    private String comentario;

}
