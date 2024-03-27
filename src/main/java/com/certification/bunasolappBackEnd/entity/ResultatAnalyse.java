package com.certification.bunasolappBackEnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ResultatAnalyse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "valeur_trouve")
	private Double valeur_trouve;
	
	@ManyToOne
	@JoinColumn(name = "elt_id")
	private ElementChimique elt_chimique;
	
	@ManyToOne
	@JoinColumn(name = "certifct_id")
	private Certification certification;

	public ResultatAnalyse(Double valeur_trouve) {
		super();
		this.valeur_trouve = valeur_trouve;
	}

	public ResultatAnalyse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValeur_trouve() {
		return valeur_trouve;
	}

	public void setValeur_trouve(Double valeur_trouve) {
		this.valeur_trouve = valeur_trouve;
	}

	public ElementChimique getElt_chimique() {
		return elt_chimique;
	}

	public void setElt_chimique(ElementChimique elt_chimique) {
		this.elt_chimique = elt_chimique;
	}

	public Certification getCertification() {
		return certification;
	}

	public void setCertification(Certification certification) {
		this.certification = certification;
	}
	
	
}
