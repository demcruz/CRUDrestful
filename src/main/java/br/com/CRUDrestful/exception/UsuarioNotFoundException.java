package br.com.CRUDrestful.exception;

public class UsuarioNotFoundException extends RuntimeException {

	public UsuarioNotFoundException(Long id) {
		super("Could not find user with id" + id + ".");
	}
	
	
	public UsuarioNotFoundException(String email) {
		super("Could not find email whith email" + email + ".");
	}
}
