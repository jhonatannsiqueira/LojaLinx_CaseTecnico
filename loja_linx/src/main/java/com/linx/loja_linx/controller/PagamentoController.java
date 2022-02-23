package com.linx.loja_linx.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linx.loja_linx.model.Pagamento;
import com.linx.loja_linx.repository.PagamentoRepository;

@RestController
@RequestMapping("/pagamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PagamentoController {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@GetMapping
	public ResponseEntity <List <Pagamento>> getAll(){
		return ResponseEntity.ok(pagamentoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Pagamento> getById(@PathVariable Long id){
		return pagamentoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/metodo/{metodo}")
	public ResponseEntity <List <Pagamento>> getByMetodo(@PathVariable String metodo){
		return ResponseEntity.ok(pagamentoRepository.findAllByMetodoContainingIgnoreCase(metodo));
	}
	
	@PostMapping
	public ResponseEntity <Pagamento> postPagamento(@Valid @RequestBody Pagamento pagamento){
		return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoRepository.save(pagamento));
	}
	
	@PutMapping
	public ResponseEntity <Pagamento> putPagamento(@Valid @RequestBody Pagamento pagamento){
		return pagamentoRepository.findById(pagamento.getId())
				.map(resposta -> ResponseEntity.ok().body(pagamentoRepository.save(pagamento)))
				.orElse(ResponseEntity.notFound().build());				
	}
	
	@PatchMapping
	public ResponseEntity <Pagamento> patchPagamento(@Valid @RequestBody Pagamento pagamento){
		return pagamentoRepository.findById(pagamento.getId())
				.map(resposta -> ResponseEntity.ok().body(pagamentoRepository.save(pagamento)))
				.orElse(ResponseEntity.notFound().build());				
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePagamento(@PathVariable Long id) {
		return pagamentoRepository.findById(id).map(resposta -> {
			pagamentoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
