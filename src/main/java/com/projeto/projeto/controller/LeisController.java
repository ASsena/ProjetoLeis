package com.projeto.projeto.controller;

import java.util.List;
import java.util.Optional;

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

	@Autowired
	private LeisRepository leisrepository
	
	@PostMapping
	public ResponseEntity<LeisModel> criarLei(@RequestBody LeisModel lei) {
	    LeisModel novaLei = leisRepository.save(lei);
	    return new ResponseEntity<>(novaLei, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<LeisModel>> listarLeis() {
	    List<LeisModel> leis = leisRepository.findAll();
	    return new ResponseEntity<>(leis, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LeisModel> buscarLeiPorId(@PathVariable Long id) {
	    Optional<LeisModel> lei = leisRepository.findById(id);
	    return lei.map(ResponseEntity::ok)
	              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<LeisModel> atualizarLei(@PathVariable Long id, @RequestBody LeisModel leiAtualizada) {
	    Optional<LeisModel> leiExistente = leisRepository.findById(id);

	    if (leiExistente.isPresent()) {
	        LeisModel lei = leiExistente.get();
	        lei.setNome(leiAtualizada.getNome());
	        lei.setNumero(leiAtualizada.getNumero());
	        lei.setDescricao(leiAtualizada.getDescricao());
	        lei.setData(leiAtualizada.getData());
	        LeisModel leiSalva = leisRepository.save(lei);
	        return new ResponseEntity<>(leiSalva, HttpStatus.OK);
	    }

	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarLei(@PathVariable Long id) {
	    if (leisRepository.existsById(id)) {
	        leisRepository.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
