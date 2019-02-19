package com.nareshit.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="DOCTOR")
public class Doctor extends User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Admin admin;

	@OneToMany
	private	Set<Nurse> nurses;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Patient> patients;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}


	

}
