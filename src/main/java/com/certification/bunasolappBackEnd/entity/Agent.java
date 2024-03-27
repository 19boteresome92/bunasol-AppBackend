package com.certification.bunasolappBackEnd.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agents")
public class Agent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String matricule;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "fonction")
	private String fonction;

	@Column(name = "titre_honorifique")
	private String titre_honorifique;

	@Column(name = "mot_de_passe")
	private String motDePasse;

	@Column(name = "role")
	private String role;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "agent_certification", joinColumns = @JoinColumn(name = "agt_id"), inverseJoinColumns = @JoinColumn(name = "certifct_id"))
	private List<Certification> certifications;

	public Agent(String nom, String prenom, String fonction, String titre_honorifique, String password, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.titre_honorifique = titre_honorifique;
		this.motDePasse = password;
		this.role = role;
	}

	public Agent() {
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getTitre_honorifique() {
		return titre_honorifique;
	}

	public void setTitre_honorifique(String titre_honorifique) {
		this.titre_honorifique = titre_honorifique;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}
