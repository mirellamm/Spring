package br.org.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.model.Postagem;
import br.org.generation.blogpessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins="*",allowedHeaders="*")
public class PostagemController {
		
		@Autowired
		private PostagemRepository postagemRepository; // tipo - objeto
		
		@GetMapping
		public ResponseEntity <List<Postagem>> getAll() // uma lista que contem varios objetos
		{ 
			return ResponseEntity.ok(postagemRepository.findAll()); // equilave a select * from tb_postagens
		}
		
		@GetMapping("/{id}")
		public ResponseEntity <Postagem> getById(@PathVariable Long id) 
		{ 
			return postagemRepository.findById(id)
					.map(resp -> ResponseEntity.ok(resp)) //função lambda
					.orElse(ResponseEntity.notFound().build());
		} // select * from tb_postagens where id = x;
		
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity <List<Postagem>> getByTitulo(@PathVariable String titulo)
		{ 
			return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
		}
		
		@PostMapping
		public ResponseEntity <Postagem> postPostagem(@Valid @RequestBody Postagem postagem) //response entiity devolve um status
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
		}
		
		@PutMapping
		public ResponseEntity <Postagem> putPostagem(@Valid @RequestBody Postagem postagem) //equivale ao update do MySQL
		{
			return postagemRepository.findById(postagem.getId())             
					.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem)))   
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); //build devolve só o status
		}
		
		@DeleteMapping(path ={"/{id}"})
		public ResponseEntity<?> delete(@PathVariable Long id) 
		{
		   return postagemRepository.findById(id)
		           .map(record -> 
		           {
		               postagemRepository.deleteById(id);
		               return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		           })
		           .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
}