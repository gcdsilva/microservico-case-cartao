package br.com.pagamento.repository;

import br.com.pagamento.entity.Pagamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {
	
	@Query("from Pagamento p WHERE p.cartaoId = :cartaoID")
	public List<Pagamento> buscaPorCartao(@Param("cartaoID") String cartaoID);

}
