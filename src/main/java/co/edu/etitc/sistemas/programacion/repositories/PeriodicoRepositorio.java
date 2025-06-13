
package co.edu.etitc.sistemas.programacion.repositories;


import java.util.Collection;


import co.edu.etitc.sistemas.programacion.model.Periodico;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodicoRepositorio extends CrudRepository<Periodico, Integer> {
    @Query("    SELECT * FROM periodico\n    WHERE nombre LIKE '%' || :criterio || '%'\n       OR editorial LIKE '%' || :criterio || '%'\n       OR TO_CHAR(fecha_publicacion, 'YYYY-MM-DD') LIKE '%' || :criterio || '%'\n       OR TO_CHAR(fecha_ingreso, 'YYYY-MM-DD HH24:MI:SS') LIKE '%' || :criterio || '%'\n       OR activo::TEXT LIKE '%' || :criterio || '%'\n")
    Collection<Periodico> findByCriteria(@Param("criterio") String var1);

    <S extends Periodico> S save(S var1);

    void delete(Periodico var1);

    Iterable<Periodico> findAll();
}
