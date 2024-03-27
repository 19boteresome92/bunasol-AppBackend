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
public class Beneficiaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;

	@Column(name = "email")
	private String email;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "contact")
	private String contact;

	@OneToMany(mappedBy = "beneficiaire", cascade = CascadeType.ALL)
	private List<Echantillon> echantillons;

	public Beneficiaire(String nom, String email, String adresse, String contact) {
		super();
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
		this.contact = contact;
	}

	public Beneficiaire(String nom) {
		super();
		this.nom = nom;
	}

	public Beneficiaire() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Echantillon> getEchantillons() {
		return echantillons;
	}

	public void setEchantillons(List<Echantillon> echantillons) {
		this.echantillons = echantillons;
	}

}
