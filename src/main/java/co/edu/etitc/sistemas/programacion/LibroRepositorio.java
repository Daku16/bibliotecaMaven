package co.edu.etitc.sistemas.programacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends CrudRepository<Libro, Integer> {

    @Query("""
        SELECT * FROM libro 
        WHERE nombre LIKE '%' || :criterio || '%' 
           OR autor LIKE '%' || :criterio || '%' 
           OR editorial LIKE '%' || :criterio || '%' 
           OR anio LIKE '%' || :criterio || '%'
    """)
    Collection<Libro> findByCriteria(String criterio);

    @Override
    <S extends Libro> S save(S entity);

    @Override
    void delete(Libro entity);

    @Override
    Iterable<Libro> findAll();
}