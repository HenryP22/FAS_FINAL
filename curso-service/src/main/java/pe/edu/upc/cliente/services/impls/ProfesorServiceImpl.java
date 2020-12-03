package pe.edu.upc.cliente.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.cliente.entities.Profesor;
import pe.edu.upc.cliente.repositories.ProfesorRepository;
import pe.edu.upc.cliente.services.ProfesorService;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Transactional
    @Override
    public Profesor save(Profesor entity) throws Exception {
        return profesorRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Profesor> findAll() throws Exception {
        return profesorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Profesor> findById(Long aLong) throws Exception {
        return profesorRepository.findById( aLong);
    }

    @Transactional
    @Override
    public Profesor update(Profesor entity) throws Exception {
        return profesorRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        profesorRepository.deleteById(aLong);
    }

    @Override
    public Optional<Profesor> findByNumeroDocumento(String numeroDocumento) throws Exception {
        return profesorRepository.findByNumeroDocumento(numeroDocumento);
    }
}
