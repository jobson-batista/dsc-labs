package model;

import java.util.Date;

public class Comentario {

    private int id;
    private Usuario usuario;
    private Date dataCriacao;
    private String descricao;

    public Comentario(Usuario usuario, String descricao) {
        this.usuario = usuario;
        this.dataCriacao = new Date();
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\n\t\tID: "+id+"\n\t\tUsuario: "+usuario.toString()+"\n\t\tDescrição: "+descricao+"\n\t\tComentado em: "+dataCriacao.toString()+"\n";
    }
}
