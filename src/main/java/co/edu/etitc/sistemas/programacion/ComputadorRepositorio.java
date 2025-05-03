package co.edu.etitc.sistemas.programacion;

import java.util.Collection;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadorRepositorio extends CrudRepository<Computador, Integer> {

    @Query("""
    SELECT * FROM computador 
    WHERE nombre LIKE '%' || :criterio || '%' 
       OR marca LIKE '%' || :criterio || '%' 
       OR modelo LIKE '%' || :criterio || '%' 
       OR sistema_operativo LIKE '%' || :criterio || '%' 
       OR tipo_computador LIKE '%' || :criterio || '%' 
       OR TO_CHAR(fecha_ingreso, 'YYYY-MM-DD HH24:MI:SS') LIKE '%' || :criterio || '%'
       OR activo::TEXT LIKE '%' || :criterio || '%'
""")
    Collection<Computador> findByCriteria(@Param("criterio") String criterio);

    @Override
    <S extends Computador> S save(S entity);

    @Override
    void delete(Computador entity);

    @Override
    Iterable<Computador> findAll();
}