package com.snet.controllers;

import com.snet.model.Comentario;
import com.snet.model.Disciplina;
import com.snet.services.DisciplinaService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    String RESPONSE404 = new JSONObject().put("message", "Não foi possível encontrar a disciplina.").toString();

    @GetMapping
    public ResponseEntity<List<Disciplina>> obterDisciplinas() {
        return new ResponseEntity<>(disciplinaService.obterDisciplinas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> obterDisciplinaPorId(@PathVariable long id) {
        Optional<Disciplina> d = disciplinaService.obterDisciplinaPorID(id);
        if(disciplinaService.obterDisciplinaPorID(id) != null){
            return new ResponseEntity(d, HttpStatus.OK);
        }
        return new ResponseEntity(RESPONSE404, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/likes/{id}")
    public ResponseEntity<Disciplina> incrementarLike(@PathVariable long id) {
        Disciplina d = disciplinaService.incrementarLike(id);
        if(d != null) {
            return new ResponseEntity(d, HttpStatus.OK);
        }
        return new ResponseEntity(RESPONSE404, HttpStatus.NOT_FOUND);

    }

    @PutMapping("/nota/{id}")
    public ResponseEntity<Disciplina> atualizarNota(@PathVariable long id, @RequestBody Disciplina dr) {
        if(dr.getNota() > 10 || dr.getNota() < 0) {
            return new ResponseEntity(new JSONObject().put("message", "A nota deve estar entre ZERO e DEZ para ser válida.").toString(), HttpStatus.BAD_REQUEST);
        }
        Disciplina d = disciplinaService.atualizarNota(id, dr.getNota());
        if(d != null) {
            return new ResponseEntity(d, HttpStatus.OK);
        }
        return new ResponseEntity(RESPONSE404, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/comentarios/{id}")
    public ResponseEntity<Disciplina> adicionarComentario(@PathVariable long id, @RequestBody Comentario comentario) {
        Disciplina d = disciplinaService.inserirComentario(id, comentario);
        if(d != null) {
            return new ResponseEntity(d, HttpStatus.OK);
        }
        return new ResponseEntity(RESPONSE404, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ranking/notas")
    public ResponseEntity<List<Disciplina>> rankingNotas() {
        List<Disciplina> disciplinas = disciplinaService.ranking('N');
        return new ResponseEntity<>(disciplinas, HttpStatus.OK);
    }

    @GetMapping("/ranking/likes")
    public ResponseEntity<List<Disciplina>>rankingLikes() {
        List<Disciplina> disciplinas = disciplinaService.ranking('L');
        return new ResponseEntity<>(disciplinas, HttpStatus.OK);
    }

}
