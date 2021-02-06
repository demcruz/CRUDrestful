package br.com.CRUDrestful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.CRUDrestful.entity.Usuario;
import br.com.CRUDrestful.exception.UsuarioNotFoundException;
import br.com.CRUDrestful.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario create(Usuario usuario) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioOptional.isPresent()) {
			throw new UsuarioNotFoundException(usuario.getEmail());
		} else {
			if (usuario.getName() == "" || usuario.getEmail() == "" || usuario.getPassword() == "") {
				throw new UsuarioNotFoundException(usuario.getEmail());
			}
			return usuarioRepository.save(usuario);
		}
	}

	public Optional<Usuario> listaUsuario(Long id) {
		Optional<Usuario> usuarioOpional = usuarioRepository.findById(id);

		if (!usuarioOpional.isPresent()) {
			throw new UsuarioNotFoundException(id);
		} else {
			return usuarioRepository.findById(id);
		}
	}

	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> listaEmail(String email) {
		Optional<Usuario> usuarioOpional = usuarioRepository.findByEmail(email);
		if (!usuarioOpional.isPresent()) {
			throw new UsuarioNotFoundException(email);
		} else {
			return usuarioRepository.findByEmail(email);
		}

	}

	public Usuario updateUsuario(Long id, Usuario usuario) {
		Optional<Usuario> usuarioOpional = usuarioRepository.findById(id);
		if (!usuarioOpional.isPresent())
			throw new UsuarioNotFoundException(id);

		Usuario usuar = usuarioRepository.findById(id).get();
		usuar.setName(usuario.getName());
		usuar.setEmail(usuario.getEmail());
		usuar.setPassword(usuario.getPassword());
		return usuarioRepository.save(usuar);

	}

	public void deleteUsuario(Long id) {
		Optional<Usuario> usuarioOpional = usuarioRepository.findById(id);
		if (!usuarioOpional.isPresent()) {
			throw new UsuarioNotFoundException(id);
		} else {
			usuarioRepository.deleteById(id);
		}
	}

}
