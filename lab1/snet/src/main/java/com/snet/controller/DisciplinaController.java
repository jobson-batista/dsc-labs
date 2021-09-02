package com.snet.controller;

import com.snet.model.Disciplina;
import com.snet.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<Disciplina> cadastrarDisciplina(@RequestBody Disciplina d) {
        if(d.getNome().isEmpty()) {
            return new ResponseEntity("Campo 'nome' não pode está vazio.",HttpStatus.BAD_REQUEST);
        }
        disciplinaService.adicionarDisciplina(d);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> obterDisciplinas() {
        return new ResponseEntity<>(disciplinaService.obterDisciplinas(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Disciplina> obterDisciplinaPorId(@PathVariable int id) {
        if(disciplinaService.obterDisciplinaPorId(id) == null) {
            return new ResponseEntity("Disciplina não existe.",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(disciplinaService.obterDisciplinaPorId(id), HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}/nome")
    public ResponseEntity<Disciplina> atualizarNomePorId(@PathVariable int id, @RequestBody Disciplina d) {
        if(disciplinaService.obterDisciplinaPorId(id) == null) {
            return new ResponseEntity("Disciplina não existe.",HttpStatus.NOT_FOUND);
        }
        disciplinaService.atualizarNomePorId(id, d.getNome());
        return new ResponseEntity(disciplinaService.obterDisciplinaPorId(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteDisciplina(@PathVariable int id){
        if(disciplinaService.obterDisciplinaPorId(id) == null) {
            return new ResponseEntity("Discplina não existe.",HttpStatus.NOT_FOUND);
        }
        disciplinaService.deleteDisciplinaById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
