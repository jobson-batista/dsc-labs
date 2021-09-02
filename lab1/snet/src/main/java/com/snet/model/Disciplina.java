package com.snet.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class Disciplina {

    private int id;
    private String nome;
    private int likes;
    private List<Double> notas = new ArrayList<>();

}
