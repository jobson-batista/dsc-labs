package controller;

import model.Usuario;
import service.UsuarioService;

import java.util.List;

public class UsuarioController {

    UsuarioService usuarioService = UsuarioService.getInstance();

    public void cadastrarUsuario(String nome, String email, String senha) {
        Usuario user = new Usuario(nome, email, senha);
        usuarioService.addUsuario(user);
    }

    public Usuario obterUsuarioEmail(String email) {
        return usuarioService.getUsuarioByEmail(email);
    }

    public List<Usuario> obterTodosUsuarios() {
        return usuarioService.getUsuarios();
    }

    public void atualiarUsuario(Usuario u) {
        usuarioService.updateUsuario(u);
    }

    public void deletarUsuario(Usuario u) {
        usuarioService.deleteUsuario(u);
    }

    public Usuario obterUsuarioAtual() {
        return usuarioService.getUsuarioAtual();
    }

    public void login(String email, String senha) {
        usuarioService.login(email, senha);
    }

    public void logout() {
        usuarioService.logout();
    }
}
