import controller.DisciplinaController;
import controller.UsuarioController;

public class Client {

    public static void main(String[] args) {

        UsuarioController usuarioController = new UsuarioController();
        DisciplinaController disciplinaController = new DisciplinaController();

        // POST
        usuarioController.cadastrarUsuario("Neo","neo@email.com","123456");
        usuarioController.cadastrarUsuario("root","root@email.com","123456");
        disciplinaController.cadastrarDisciplina("Desenvolvimento de Sistemas Corporativo",5,8.9);
        disciplinaController.cadastrarDisciplina("Inteligencia Artificial",99,9.1);

        // PUT
        disciplinaController.atualizarNomePeloId(1, "DSC");
        disciplinaController.atualizarNotaPeloId(1, 10.0);

        // Login
        usuarioController.login("neo@email.com","123456");

        // Saídas
        System.out.println("Usuários cadastrados = " + usuarioController.obterTodosUsuarios());
        System.out.println("Usuário Ativo = " + usuarioController.obterUsuarioAtual().getNome()+"\n");
        System.out.println("Disciplinas Cadastradas = "+disciplinaController.obterTodasDisciplinas());
    }
}
