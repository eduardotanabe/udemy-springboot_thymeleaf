package com.mballem.curso.boot.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")    // como o próprio JDK irá gerar os números do id, foi suprimido para que o Eclipse não fique pedindo para que crie um ID serializable, já que esta class tbm implementa o Serializable
@MappedSuperclass    // esta anotação é para avisar que esta é uma superclasse das outras que iremos implementar 
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {   // o ID extends Serializable obriga as classes filhas a escolher o tipo de dado para o ID (no caso seria a chave primária), pois o ID foi considerado como genérico
																						// Fez o implements Serializable pq os padrões d boa práticas diz q quando se usa o framework ORM (Mapeamento Objeto Relacional) deve se usar todas as classe serializadas
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;   // como em cima (na linha 11) foi adicionado que o ID é genérico, então esta linha é do tipo genérico, com as classses filhas necesstando definir o tipo de dado

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {    // esse hash code foi escrito pelo Eclipse
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {  // esse método foi escrito pelo Eclipse	
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity<?> other = (AbstractEntity<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id = " + id;
	}
	
	
	





}
