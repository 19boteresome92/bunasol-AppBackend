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
public class TypeAnalyse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "type_controle")
	private String type_controle;
	
	@OneToMany(mappedBy = "type_analyse",cascade = CascadeType.ALL)
	private List<Certification> certifications;

	public TypeAnalyse(String type_controle) {
		super();
		this.type_controle = type_controle;
	}

	public TypeAnalyse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType_controle() {
		return type_controle;
	}

	public void setType_controle(String type_controle) {
		this.type_controle = type_controle;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}
	
	
}
