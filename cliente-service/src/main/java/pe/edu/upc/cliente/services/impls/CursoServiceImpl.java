package pe.edu.upc.cliente.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.cliente.entities.Curso;
import pe.edu.upc.cliente.repositories.CursoRepository;
import pe.edu.upc.cliente.services.CursoService;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    @Override
    public Curso save(Curso entity) throws Exception {
        return cursoRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Curso> findAll() throws Exception {
        return cursoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Curso> findById(Long aLong) throws Exception {
        return cursoRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Curso update(Curso entity) throws Exception {
        return cursoRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        cursoRepository.deleteById(aLong);
    }
}
