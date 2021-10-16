package com.snet.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snet.respositories.DisciplinaRepository;
import com.snet.model.Comentario;
import com.snet.model.Disciplina;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository<Disciplina, Long> disciplinaRepository;

    @PostConstruct
    public void initDisciplinas() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>(){};
        InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/disciplinas.json");
        try {
            List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference);
            this.disciplinaRepository.saveAll(disciplinas);
            System.out.println("Disciplinas cadastradas com sucesso !");
        } catch (IOException e) {
            System.out.println("Não foi possível salvar as disciplinas no boot: "+e.getMessage());
        }
    }

    public List<Disciplina> obterDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> obterDisciplinaPorID(long id) {
        if(id >= 0 && disciplinaRepository.existsById(id)) {
            return disciplinaRepository.findById(id);
        }
        return null;
    }

    public Disciplina incrementarLike(long id) {
        for(Disciplina d: disciplinaRepository.findAll()) {
            if(d.getId() == id) {
                d.setLikes(d.getLikes() + 1);
                disciplinaRepository.save(d);
                return d;
            }
        }
        return null;
    }

    public Disciplina atualizarNota(long id, double nota) {
        for(Disciplina d: disciplinaRepository.findAll()) {
            if(d.getId() == id) {
                d.setNota((d.getNota() + nota) / 2);
                disciplinaRepository.save(d);
                return d;
            }
        }
        return null;
    }

    public Disciplina inserirComentario(long id, Comentario comentario) {
        if(disciplinaRepository.existsById(id)) {
            for(Disciplina d: disciplinaRepository.findAll()) {
                if(d.getId() == id) {
                    List<Comentario> comentariosAtualizado = d.getComentarios();
                    comentariosAtualizado.add(comentario);
                    d.setComentarios(comentariosAtualizado);
                    disciplinaRepository.save(d);
                    return d;
                }
            }
        }
        return null;
    }

    public List<Disciplina> ranking(char tipo) {
        List<Disciplina> disciplinas = disciplinaRepository.findAll();
        if(tipo == 'N') {
            Comparator<Disciplina> compararPelaNota = Comparator.comparing(t -> t.getNota());
            disciplinas.sort(compararPelaNota.reversed());
        } else if (tipo == 'L') {
            Comparator<Disciplina> compararPeloLike = Comparator.comparing(t -> t.getLikes());
            disciplinas.sort(compararPeloLike.reversed());
        }
        return disciplinas;

    }
}
