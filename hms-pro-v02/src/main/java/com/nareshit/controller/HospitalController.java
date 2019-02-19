package com.nareshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.DoctorBean;
import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;
import com.nareshit.repository.IHospitalRepository;
import com.nareshit.utility.HospitalMapper;

//@RestController
@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private IHospitalRepository hospRepo;
	
	@RequestMapping
	public String getHomePage(Model model) {
		String msg = "welcome to hms pro";
		model.addAttribute("message", msg);
		model.addAttribute("hospBean", new HospitalBean());
		
		return "home";
	}
	
	@GetMapping(value="/getHospitalPage")
	public String addHospotal(Model model) {
		model.addAttribute("hospBean", new HospitalBean());
		return "addHospital";
				
		
	}
	
	@PostMapping(value="/addHospital")
	public String addHospotal(@ModelAttribute("hospBean") HospitalBean hospBean, Model model) {
		
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		hosp = hospRepo.save(hosp);
		hospBean = HospitalMapper.mapDomainToBean(hosp);
		String msg="Hospital '"+hospBean.getName()+"' added Successfully";
		model.addAttribute("hospBean", new HospitalBean());
		model.addAttribute("message", msg);
		
		return "addHospital";
		
	}
	

	@RequestMapping("/addDoctor")
	public String addDoctor(Model model) {
		model.addAttribute("docBean", new DoctorBean());
		return  "addDoctor";
	}
	
	public String addDoctor(@ModelAttribute("docBean") DoctorBean docBean, ModelMap map) {
	return null;
	}
}
