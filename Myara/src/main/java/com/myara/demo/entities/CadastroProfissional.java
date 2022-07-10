package com.myara.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Profssional")
public class CadastroProfissional {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
	@Column(length=40)
     private String nome;
	
	@Column(length=40)
     private String email;
	
	@Column(length=40)
     private String senha;
	
	@Column(length=40)
     private String Cpf;
	
	@Column(length=40)
     private String telefone;
	
	@Column(length=40)
     private String recursos_humanos;
	
	@Column(length=40)
     private String comercial;
	
	@Column(length=40)
     private String ti;
	
	@Column(length=40)
     private String administrativo;
	
	@Column(length=40)
     private String operacional;
	
	@Column(length=40)
     private String segurança;
	
	@Column(length=40)
     private String almoxarifado;
	
	@Column(length=40)
     private String financeiro;
	
	@Column(length=40)
     private String higienização;
	
 

     
}
