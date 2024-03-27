package com.certification.bunasolappBackEnd.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Echantillon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "qte")
	private Double quantite;
	
	@Column(name = "nro_insp")
	private String numero_inspection;
	
	@Column(name = "lot")
	private String lot;
	
	@Column(name = "lieu_prelev")
	private String lieu_prelevement;
	
	@Column(name = "ville")
	private String ville;
	
	@Column(name = "statut")
	private String statut;
	
	@OneToMany(mappedBy = "echantillon",cascade = CascadeType.ALL)
	private List<Certification> certifications;
	
	@ManyToOne
	@JoinColumn(name = "beneficiaire_id")
	private Beneficiaire beneficiaire;
	
	@ManyToOne
	@JoinColumn(name = "type_echt_id")
	private TypeEchantillon type_echantillon;

	public Echantillon(String code, Double quantite, String numero_inspection, String lot, String lieu_prelevement,
			String ville, String statut) {
		super();
		this.code = code;
		this.quantite = quantite;
		this.numero_inspection = numero_inspection;
		this.lot = lot;
		this.lieu_prelevement = lieu_prelevement;
		this.ville = ville;
		this.statut = statut;
	}

	public Echantillon() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	public String getNumero_inspection() {
		return numero_inspection;
	}

	public void setNumero_inspection(String numero_inspection) {
		this.numero_inspection = numero_inspection;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getLieu_prelevement() {
		return lieu_prelevement;
	}

	public void setLieu_prelevement(String lieu_prelevement) {
		this.lieu_prelevement = lieu_prelevement;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public TypeEchantillon getType_echantillon() {
		return type_echantillon;
	}

	public void setType_echantillon(TypeEchantillon type_echantillon) {
		this.type_echantillon = type_echantillon;
	}
	
	
}
