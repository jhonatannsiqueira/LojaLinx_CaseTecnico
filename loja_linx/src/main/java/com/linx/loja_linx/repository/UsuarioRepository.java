package com.linx.loja_linx.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linx.loja_linx.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
	
	public Optional<Usuario> findByUsuario(String usuario);
	// Optional, pois essa pesquisa pode retornar um Nulo.
	
	public List <Usuario> findAllByNomeContainingIgnoreCase(String nome);

}
