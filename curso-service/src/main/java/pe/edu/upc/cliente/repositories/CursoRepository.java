package pe.edu.upc.cliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.cliente.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {
}
