package model;

import java.util.List;

public class Disciplina {

    private int id;
    private String nome;
    private List<Comentario> comentarios;
    private int likes;
    private double nota;

    public Disciplina(String nome, int likes, double nota) {
        this.nome = nome;
        this.likes = likes;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List getComentarios() {
        return comentarios;
    }

    public void setComentarios(List comentarios) {
        this.comentarios = comentarios;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        if(comentarios != null) {
            return "\n\tID: "+id+"\n\tNome: "+nome+"\n\tComentários: "+ comentarios.toString() +"\n\tLikes: "+likes+"\n\tNota: "+nota+"\n\n";
        }
        return "";
    }

}
