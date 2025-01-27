package com.projeto.projeto.controller;

import java.util.List;
import java.util.Optional;

import com.projeto.projeto.dto.LeiDTO;
import com.projeto.projeto.service.LeisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leis")
public class LeisController {

	private LeisService leisService;

	@GetMapping
	public ResponseEntity<?> verLeis() {
		return ResponseEntity.ok().body(leisService.listarLeis());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> verLeisId(@PathVariable Long id) {
		return ResponseEntity.ok().body(leisService.encontrarId(id));
	}

	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody LeiDTO leiDTO){
		leisService.salvar(leiDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		leisService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody LeiDTO leiDTO){
		leisService.autalizar(id, leiDTO);
		return ResponseEntity.noContent().build();
	}

}
