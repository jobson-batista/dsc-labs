package com.snet.repository;

import com.snet.model.Disciplina;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class DisciplinaRepository {

    // Única instância - Singleton
    private static DisciplinaRepository instancia = new DisciplinaRepository();

    public static DisciplinaRepository getInstancia(){ return instancia; };

    @Getter @Setter
    private List<Disciplina> disciplinas = new ArrayList<>();

    public void save(Disciplina d) {
        disciplinas.add(d);
    }

    public Disciplina findById(int id) {
        for(Disciplina d: disciplinas) {
            if(d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public List<Disciplina> findAll() {
        return disciplinas;
    }

    public Disciplina updateNameById(int id, String newName) {
        for(Disciplina d: disciplinas) {
            if(d.getId() == id){
                d.setNome(newName);
                return d;
            }
        }
        return null;
    }

    public Disciplina updateNotaById(int id, double newNota) {
        for(Disciplina d: disciplinas) {
            if(d.getId() == id){
                List<Double> notas = d.getNotas();
                notas.add(newNota);
                d.setNotas(notas);
                return d;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        for(Disciplina d: disciplinas) {
            if(d.getId() == id){
                disciplinas.remove(d);
            }
        }
    }

}
