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
import pe.edu.upc.cliente.services.ProfesorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Profesor>> fetchAll() {
        try {
            List<Profesor> clientes = profesorService.findAll();
            return new ResponseEntity<List<Profesor>>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profesor> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Profesor> optionalCliente = profesorService.findById(id);
            if(optionalCliente.isPresent()) {
                return new ResponseEntity<Profesor>(optionalCliente.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(path = "/documento/{numeroDocumento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profesor> fetchByDocumento(@PathVariable("numeroDocumento") String numeroDocumento) {
        try {
            Optional<Profesor> optionalCliente = profesorService.findByNumeroDocumento(numeroDocumento);
            if(optionalCliente.isPresent()) {
                return ResponseEntity.ok(optionalCliente.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
