package com.nareshit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.nareshit.bean.DoctorBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Doctor;
import com.nareshit.domain.Patient;
import com.nareshit.domain.Patient;
import com.nareshit.service.DoctorService;
import com.nareshit.service.PatientService;
import com.nareshit.utility.DoctorMapper;
import com.nareshit.utility.PatientMapper;
import com.nareshit.utility.PatientMapper;


//@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	

	

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patService;
	
	@RequestMapping
	public String getAdminBoard(Model model) {
		List<DoctorBean> docBeanList = doctorService.getAllDoctors();
		model.addAttribute("docBeanList", docBeanList);
		return "adminBoard";
				
	}
	
	@RequestMapping(value="/doctorMgmt")
	public String getDoctorBoard(Model model) {
		List<DoctorBean> docBeanList = doctorService.getAllDoctors();
		model.addAttribute("docBeanList", docBeanList);
		return "adminBoard";
	}
	
	@RequestMapping(value="/patientMgmt")
	public String getPatientBoard(Model model) {
		List<PatientBean> patBeanList = patService.getAllPatients();
		model.addAttribute("patBeanList", patBeanList);
		return "adminPatientBoard";
	}
	
	@RequestMapping(value="/doctorMgmt/addDoctorDefn")
	public String addDoctorByAdmin(Model model) {
		System.out.println("get doctor page in admin");
		model.addAttribute("doctBean", new DoctorBean());
		return "addDoctorDefnByAdmin";
	}
	
	@RequestMapping(value="/patientMgmt/addPatientDefn")
	public String addPatientByAdmin(Model model) {
		System.out.println("get patient page in admin");
		model.addAttribute("patBean", new PatientBean());
		return "addPatientDefnByAdmin";
	}
	
	@RequestMapping(value="/doctorMgmt/addDoctor")
	public String addpatotal(@ModelAttribute("doctBean") DoctorBean doctBean, Model model) {
		System.out.println("add Patient ");
		System.out.println("patal data is:\t"+doctBean.getStatus());
		doctBean =  doctorService.saveDoctor(doctBean);
		if(doctBean != null && doctBean.getId() >0) {
			List<DoctorBean> docBeanList = doctorService.getAllDoctors();
			model.addAttribute("docBeanList", docBeanList);
		}
		return "adminBoard";
	}
	
	@RequestMapping(value="/patientMgmt/addPatient")
	public String addPatient(@ModelAttribute("patBean") PatientBean patBean, Model model) {
		System.out.println("add Patient ");
		System.out.println("patal data is:\t"+patBean.getStatus());
		Patient pat = PatientMapper.mapBeanToDomain(patBean);
		//pat = patRepo.save(pat);
		patBean =  patService.savePatient(pat);
		if(patBean != null && patBean.getId() >0) {
			List<PatientBean> patBeanList = patService.getAllPatients();
			model.addAttribute("patBeanList", patBeanList);
		}
		return "adminPatientBoard";
	}
	
	@GetMapping(value="/patientMgmt/editPat/{id}")
	public String  editPatient(Model  model,@PathVariable("id") int id) {
		PatientBean patBean = patService.getPatientById(id);
		model.addAttribute("patBean", patBean);
		return "adminPatientEditBoard";
	}
	
	@PostMapping(value="/patientMgmt/updatePatient")
	public String updatePatient(@ModelAttribute("patBean") PatientBean patBean,Model model) {
		System.out.println("add Patient ");
		System.out.println(patBean.getId());
		System.out.println(patBean.getEmail());
		Patient pat = PatientMapper.mapBeanToDomain(patBean);
		patBean = patService.updatePatient(pat);
		if(patBean != null && patBean.getId() >0) {
			List<PatientBean> patBeanList = patService.getAllPatients();
			model.addAttribute("patBeanList", patBeanList);
		}
		return "adminPatientBoard";
		
	}
	
	
	
	
}
