package br.com.fatura.repository;

import br.com.fatura.entity.FaturaPaga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepository extends CrudRepository<FaturaPaga, Long> {
}



