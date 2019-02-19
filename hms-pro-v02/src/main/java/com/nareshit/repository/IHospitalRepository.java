package com.nareshit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nareshit.domain.Hospital;

public interface IHospitalRepository extends CrudRepository<Hospital, Integer> {
	
	public List<Hospital>  findHospitalByName(String name);
}
