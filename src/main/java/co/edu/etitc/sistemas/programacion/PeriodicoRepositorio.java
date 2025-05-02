package co.edu.etitc.sistemas.programacion;

import java.util.Collection;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodicoRepositorio extends CrudRepository<Periodico, Integer> {
    @Query("""
        SELECT * FROM periodico 
        WHERE nombre LIKE '%' || :criterio || '%' 
           OR editorial LIKE '%' || :criterio || '%' 
           OR TO_CHAR(fecha_publicacion, 'YYYY-MM-DD') LIKE '%' || :criterio || '%'
           OR TO_CHAR(fecha_ingreso, 'YYYY-MM-DD HH24:MI:SS') LIKE '%' || :criterio || '%'
           OR activo::TEXT LIKE '%' || :criterio || '%'
    """)
    Collection<Periodico> findByCriteria(String criterio);

    @Override
    <S extends Periodico> S save(S entity);

    @Override
    void delete(Periodico entity);

    @Override
    Iterable<Periodico> findAll();
}