package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Doctor;

public interface DoctorDao {

	public Doctor addDoctor(Doctor hosp);
	public Doctor getDoctorByid(int id);
	public List<Doctor> getAllDoctors();
	public List<Doctor> searchDoctor(String name, String email);
	
}
