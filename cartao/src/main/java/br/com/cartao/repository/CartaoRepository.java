package br.com.cartao.repository;

import br.com.cartao.entity.Cartao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Long> {
	
	@Query("from Cartao c WHERE c.numero = :numeroID")
	public List<Cartao> buscaPorNumero(@Param("numeroID") String numeroCartao);

	@Query("from Cartao c WHERE c.id = :id and c.clienteId = :clienteId")
	public List<Cartao> buscaPorIdClienteCartao( @Param("clienteId") String clienteId, @Param("id") String id);



}
