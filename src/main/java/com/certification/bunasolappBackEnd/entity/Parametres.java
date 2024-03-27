package com.certification.bunasolappBackEnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parametres {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code_deb_enreg")
	private Long code_debut_enregistrement;

	@Column(name = "timbre1")
	private String timbre1;

	@Column(name = "sigle1")
	private String sigle1;

	@Column(name = "timbre2")
	private String timbre2;

	@Column(name = "sigle2")
	private String sigle2;

	@Column(name = "timbre3")
	private String timbre3;

	@Column(name = "sigle3")
	private String sigle3;

	@Column(name = "timbre4")
	private String timbre4;

	@Column(name = "sigle4")
	private String sigle4;

	@Column(name = "timbre5")
	private String timbre5;

	@Column(name = "sigle5")
	private String sigle5;

	@Column(name = "code_ordre")
	private String code_ordre;

	@Column(name = "logo_labo")
	private String logo_labo;

	public Parametres(Long code_debut_enregistrement, String timbre1, String timbre2, String timbre3, String timbre4,
			String timbre5, String code_ordre, String logo_labo) {
		super();
		this.code_debut_enregistrement = code_debut_enregistrement;
		this.timbre1 = timbre1;
		this.timbre2 = timbre2;
		this.timbre3 = timbre3;
		this.timbre4 = timbre4;
		this.timbre5 = timbre5;
		this.code_ordre = code_ordre;
		this.logo_labo = logo_labo;
	}

	public Parametres() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCode_debut_enregistrement() {
		return code_debut_enregistrement;
	}

	public void setCode_debut_enregistrement(Long code_debut_enregistrement) {
		this.code_debut_enregistrement = code_debut_enregistrement;
	}

	public String getTimbre1() {
		return timbre1;
	}

	public void setTimbre1(String timbre1) {
		this.timbre1 = timbre1;
	}

	public String getTimbre2() {
		return timbre2;
	}

	public void setTimbre2(String timbre2) {
		this.timbre2 = timbre2;
	}

	public String getTimbre3() {
		return timbre3;
	}

	public void setTimbre3(String timbre3) {
		this.timbre3 = timbre3;
	}

	public String getTimbre4() {
		return timbre4;
	}

	public void setTimbre4(String timbre4) {
		this.timbre4 = timbre4;
	}

	public String getTimbre5() {
		return timbre5;
	}

	public void setTimbre5(String timbre5) {
		this.timbre5 = timbre5;
	}

	public String getCode_ordre() {
		return code_ordre;
	}

	public String getSigle1() {
		return sigle1;
	}

	public void setSigle1(String sigle1) {
		this.sigle1 = sigle1;
	}

	public String getSigle2() {
		return sigle2;
	}

	public void setSigle2(String sigle2) {
		this.sigle2 = sigle2;
	}

	public String getSigle3() {
		return sigle3;
	}

	public void setSigle3(String sigle3) {
		this.sigle3 = sigle3;
	}

	public String getSigle4() {
		return sigle4;
	}

	public void setSigle4(String sigle4) {
		this.sigle4 = sigle4;
	}

	public String getSigle5() {
		return sigle5;
	}

	public void setSigle5(String sigle5) {
		this.sigle5 = sigle5;
	}

	public void setCode_ordre(String code_ordre) {
		this.code_ordre = code_ordre;
	}

	public String getLogo_labo() {
		return logo_labo;
	}

	public void setLogo_labo(String logo_labo) {
		this.logo_labo = logo_labo;
	}

}
