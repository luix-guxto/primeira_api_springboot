package dio.primeira_api.repository;

import dio.primeira_api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.name = ':name'")
    Produto findByName(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Produto p WHERE p.name = ':name'")
    Boolean existProdutoByName(@Param("name") String name);
}
