package co.edu.etitc.sistemas.programacion.repositories;

import java.util.Collection;

import co.edu.etitc.sistemas.programacion.model.Libro;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
    Collection<Libro> findByCriteria(@Param("criterio") String criterio);

    @Override
    <S extends Libro> S save(S entity);

    @Override
    void delete(Libro entity);

    @Override
    Iterable<Libro> findAll();
}