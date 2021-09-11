package controller;

import service.DisciplinaService;
import model.Disciplina;

import java.util.List;

public class DisciplinaController {

    DisciplinaService disciplinaService = DisciplinaService.getInstance();

    public void cadastrarDisciplina(String nome, int likes, double notas) {
        Disciplina disciplina = new Disciplina(nome, likes, notas);
        disciplinaService.addDisciplina(disciplina);
    }

    public List<Disciplina> obterTodasDisciplinas() {
        return disciplinaService.getDisciplinas();
    }

    public Disciplina atualizarNomePeloId(int id, String nome) {
        return disciplinaService.updateNomeById(id,nome);
    }

    public Disciplina atualizarNotaPeloId(int id, double nota) {
        return disciplinaService.updateNotaById(id,nota);
    }
}
