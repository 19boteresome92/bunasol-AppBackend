package com.certification.bunasolappBackEnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Methode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "intitule")
	private String intitule;

	@ManyToOne
	@JoinColumn(name = "elt_id")
	private ElementChimique elt_chimique;

	public Methode(String intitule) {
		super();
		this.intitule = intitule;
	}

	public Methode() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public ElementChimique getElt_chimique() {
		return elt_chimique;
	}

	public void setElt_chimique(ElementChimique elt_chimique) {
		this.elt_chimique = elt_chimique;
	}
}
