package com.nareshit.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Nurse extends User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Doctor doctor;
	
	@ManyToOne
	private Patient patient;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nid")
	private Integer id;
	
}
