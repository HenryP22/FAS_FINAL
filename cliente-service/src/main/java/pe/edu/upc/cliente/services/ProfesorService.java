package pe.edu.upc.cliente.services;

import pe.edu.upc.cliente.entities.Profesor;

import java.util.Optional;

public interface ProfesorService extends CrudService<Profesor, Long> {
    Optional<Profesor> findByNumeroDocumento(String numeroDocumento) throws Exception;
}
