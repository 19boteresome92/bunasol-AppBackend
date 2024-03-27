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
public class Laboratoire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom_labo")
	private String nom_labo;
	
	@Column(name = "code_labo")
	private String code_labo;
	
	@OneToMany(mappedBy = "laboratoire",cascade = CascadeType.ALL)
	private List<Certification> certifications;

	public Laboratoire(String nom_labo, String code_labo) {
		super();
		this.nom_labo = nom_labo;
		this.code_labo = code_labo;
	}

	public Laboratoire() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_labo() {
		return nom_labo;
	}

	public void setNom_labo(String nom_labo) {
		this.nom_labo = nom_labo;
	}

	public String getCode_labo() {
		return code_labo;
	}

	public void setCode_labo(String code_labo) {
		this.code_labo = code_labo;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}
	
	
}
