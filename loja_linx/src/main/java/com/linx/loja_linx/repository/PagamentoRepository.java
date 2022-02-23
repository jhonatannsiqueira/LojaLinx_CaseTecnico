package com.linx.loja_linx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linx.loja_linx.model.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository <Pagamento, Long> {
	
	public List <Pagamento> findAllByMetodoContainingIgnoreCase(String metodo);

}
