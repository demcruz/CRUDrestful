package br.com.CRUDrestful.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.CRUDrestful.entity.Usuario;
import br.com.CRUDrestful.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;	
	
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST )
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
		Usuario createUsuario = usuarioService.create(usuario);
		
		
		return ResponseEntity.ok().body(createUsuario);
	}
	
	@RequestMapping(value = "search/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Optional<Usuario>> listUsuario(@PathVariable Long id){
		return ResponseEntity.ok().body(usuarioService.listaUsuario(id));
	}
	
	
	@RequestMapping(value= "search-all", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Usuario>> listAll(){
		return ResponseEntity.ok().body(usuarioService.listarTodos());
	}
	
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
		return ResponseEntity.ok().body(usuarioService.updateUsuario(id, usuario));
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteUsuario(id);
	}
	
	
	
}
