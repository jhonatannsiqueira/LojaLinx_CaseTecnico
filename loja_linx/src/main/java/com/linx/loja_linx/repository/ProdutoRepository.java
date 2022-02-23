package com.linx.loja_linx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linx.loja_linx.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
	
	public List <Produto> findAllByProdutoContainingIgnoreCase(String produto);

}
