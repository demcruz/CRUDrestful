package br.com.CRUDrestful.exception;

public class UsuarioNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3383055102056864418L;


	public UsuarioNotFoundException(Long id) {
		super("Could not find user with id" + id + ".");
	}
	
	
	public UsuarioNotFoundException(String email) {
		super("Could not find email whith email" + email + ".");
	}
}
