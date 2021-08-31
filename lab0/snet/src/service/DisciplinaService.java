package service;
import model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaService {

    private static DisciplinaService instancia = new DisciplinaService();
    private DisciplinaService() {}
    public static DisciplinaService getInstance() { return instancia; }

    private List<Disciplina> disciplinas = new ArrayList<>();
    private int ultimoIdDisciplina = 0;

    public void addDisciplina(Disciplina d) {
        ultimoIdDisciplina++;
        d.setId(ultimoIdDisciplina);
        disciplinas.add(d);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina getDisciplinaById(int id) {
        for(Disciplina d: disciplinas) {
            if(d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public Disciplina updateNomeById(int id, String nome) {
        for(Disciplina d: disciplinas) {
            if(d.getId() == id) {
                d.setNome(nome);
                return d;
            }
        }
        return null;
    }

    public Disciplina updateNotaById(int id, double nota) {
        for(Disciplina d: disciplinas) {
            if(d.getId() == id) {
                d.setNota(nota);
                return d;
            }
        }
        return null;
    }



}
