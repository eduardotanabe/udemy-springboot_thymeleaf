package com.mballem.curso.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long>{    // esse Long está determinando o tipo de dado do ID
	
	@Column(nullable = false, unique = true, length = 60)
	private String nome;

	@OneToMany(mappedBy = "departamento")  // esse mappedBy foi adicionado pq o relacionamento será bidirecional. O lado que tem o mappedBy é lado fraco da relação
	private List<Cargo> cargos;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
	
}
