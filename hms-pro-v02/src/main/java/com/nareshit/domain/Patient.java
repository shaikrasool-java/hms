package com.nareshit.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT")
public class Patient extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Doctor doctor;

	@OneToMany
	private Set<Nurse> nurses;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;


}
