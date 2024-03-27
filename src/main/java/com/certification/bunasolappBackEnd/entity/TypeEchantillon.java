package com.certification.bunasolappBackEnd.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TypeEchantillon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "libelle")
	private String libelle;
	
	@OneToMany(mappedBy = "type_echantillon",cascade = CascadeType.ALL)
	private List<Echantillon> echantillons;

	public TypeEchantillon(String libelle) {
		super();
		this.libelle = libelle;
	}

	public TypeEchantillon() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Echantillon> getEchantillons() {
		return echantillons;
	}

	public void setEchantillons(List<Echantillon> echantillons) {
		this.echantillons = echantillons;
	}
	
	
}
