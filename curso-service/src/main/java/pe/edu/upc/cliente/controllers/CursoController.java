package pe.edu.upc.cliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.cliente.entities.Profesor;
import pe.edu.upc.cliente.entities.Curso;
import pe.edu.upc.cliente.services.CursoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reseñas")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Curso>> fetchAll() {
        try {
            List<Curso> cursos = cursoService.findAll();
            return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Curso> optionalCurso = cursoService.findById(id);
            if(optionalCurso.isPresent()) {
                return new ResponseEntity<Curso>(optionalCurso.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
