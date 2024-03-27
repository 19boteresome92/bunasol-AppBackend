package com.certification.bunasolappBackEnd.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Certification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date_certification")
	private Date date_certification;
	
	@Column(name = "numero_ordre")
	private String numero_ordre;
	
	@Column(name = "obvservations")
	private String observations;
	
	@OneToMany(mappedBy = "certification",cascade = CascadeType.ALL)
	private List<ResultatAnalyse> resultats_analyses;
	
	@ManyToMany(mappedBy = "certifications")
	private List<Agent> agents;
	
	@ManyToOne
	@JoinColumn(name = "type_anlys_id")
	private TypeAnalyse type_analyse;
	
	@ManyToOne
	@JoinColumn(name = "echantillon_id")
	private Echantillon echantillon;
	
	@ManyToOne
	@JoinColumn(name = "labo_id")
	private Laboratoire laboratoire;

	public Certification(Date date_certification, String numero_ordre, String observations) {
		super();
		this.date_certification = date_certification;
		this.numero_ordre = numero_ordre;
		this.observations = observations;
	}

	public Certification() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_certification() {
		return date_certification;
	}

	public void setDate_certification(Date date_certification) {
		this.date_certification = date_certification;
	}

	public String getNumero_ordre() {
		return numero_ordre;
	}

	public void setNumero_ordre(String numero_ordre) {
		this.numero_ordre = numero_ordre;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public List<ResultatAnalyse> getResultats_analyses() {
		return resultats_analyses;
	}

	public void setResultats_analyses(List<ResultatAnalyse> resultats_analyses) {
		this.resultats_analyses = resultats_analyses;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	public TypeAnalyse getType_analyse() {
		return type_analyse;
	}

	public void setType_analyse(TypeAnalyse type_analyse) {
		this.type_analyse = type_analyse;
	}

	public Echantillon getEchantillon() {
		return echantillon;
	}

	public void setEchantillon(Echantillon echantillon) {
		this.echantillon = echantillon;
	}

	public Laboratoire getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}
	
	
}
