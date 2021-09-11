package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    // Singleton
    static private UsuarioService instancia = new UsuarioService();
    private UsuarioService() {}
    public static UsuarioService getInstance() { return instancia; }

    private List<Usuario> usuarios = new ArrayList<>();
    private boolean logado = false;
    private Usuario usuarioAtual= new Usuario();

    public String addUsuario(Usuario newUser) {
        try {
            this.usuarios.add(newUser);
            return "Usuário cadastrado com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public List<Usuario> getUsuarios() {
       return usuarios;
    }

    public Usuario getUsuarioByEmail(String email) {
        for(Usuario u: usuarios) {
            if(u.getEmail() == email) {
                return u;
            }
        }
        return null;
    }

    public Usuario updateUsuario(Usuario usuario) {
        for(Usuario u: usuarios) {
            if(u.getEmail() == usuario.getEmail()) {
                int index = usuarios.indexOf(u);
                usuarios.set(index, usuario);
                return usuarios.get(index);
            }
        }
        return null;
    }

    public void deleteUsuario(Usuario u) {
        usuarios.remove(u);
    }

    public Usuario getUsuarioAtual() {
        return this.usuarioAtual;
    }

    public void login(String email, String senha) {
        for(Usuario u: usuarios) {
            if(u.getEmail() == email && u.getSenha() == senha) {
                usuarioAtual = u;
                this.logado = true;
            }
        }
    }

    public void logout() {
        usuarioAtual.setNome("");
        usuarioAtual.setEmail("");
        usuarioAtual.setSenha("");
        this.logado = false;
    }
}
