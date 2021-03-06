package br.com.CRUDrestful.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario implements  Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1660108162726818579L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "email")
	private String email;	
	
	@Column(name = "senha")
	private String password;	

}
