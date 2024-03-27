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
public class ElementChimique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "formule_Chimique")
	private String formule_chimique;
	
	@OneToMany(mappedBy = "elt_chimique",cascade = CascadeType.ALL)
	private List<Methode> methodes;
	
	@OneToMany(mappedBy = "elt_chimique",cascade = CascadeType.ALL)
	private List<ResultatAnalyse> resultats_analyses;

	public ElementChimique(String designation, String formule_chimique) {
		super();
		this.designation = designation;
		this.formule_chimique = formule_chimique;
	}

	public ElementChimique() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFormule_chimique() {
		return formule_chimique;
	}

	public void setFormule_chimique(String formule_chimique) {
		this.formule_chimique = formule_chimique;
	}

	public List<Methode> getMethodes() {
		return methodes;
	}

	public void setMethodes(List<Methode> methodes) {
		this.methodes = methodes;
	}

	public List<ResultatAnalyse> getResultats_analyses() {
		return resultats_analyses;
	}

	public void setResultats_analyses(List<ResultatAnalyse> resultats_analyses) {
		this.resultats_analyses = resultats_analyses;
	}
	
	
}
