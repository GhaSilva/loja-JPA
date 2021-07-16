package br.com.ghabriel.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Embedded
	private DadosPessoais dadosPessoais;
	
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf) {
		this.dadosPessoais = new DadosPessoais(nome, cpf);

		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	
	
}
