package com.snet.service;

import com.snet.model.Disciplina;
import com.snet.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private DisciplinaRepository disciplinaRepository = DisciplinaRepository.getInstancia();
    private int lastId = 0;

    public void adicionarDisciplina(Disciplina disciplina) {
        try {
            lastId++;
            disciplina.setId(lastId);
            disciplinaRepository.save(disciplina);
        } catch(Exception e) {
            System.out.println("\nErro: \n"+e.getMessage());
        }
    }

    public List<Disciplina> obterDisciplinas() {
        try {
            return disciplinaRepository.getDisciplinas();
        } catch (Exception e ) {
            System.out.println("\nErro: \n"+e.getMessage());
        }
        return null;
    }

    public Disciplina obterDisciplinaPorId(int id) {
        try {
            return disciplinaRepository.findById(id);
        } catch (Exception e) {
            System.out.println("\nErro: \n"+e.getMessage());
        }
        return null;
    }

    public Disciplina atualizarNomePorId(int id, String nome) {
        try {
            return disciplinaRepository.updateNameById(id, nome);
        } catch (Exception e) {
            System.out.println("\nErro: \n"+e.getMessage());
        }
        return null;
    }

    public void deleteDisciplinaById(int id) {
        try {
            disciplinaRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("\nErro: \n"+e.getMessage());
        }
    }
}
