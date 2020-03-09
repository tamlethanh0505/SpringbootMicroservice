package com.tuanbong2000.admissionservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tuanbong2000.admissionservice.modles.DiseasesList;
import com.tuanbong2000.admissionservice.modles.EmployeesList;
import com.tuanbong2000.admissionservice.modles.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	List<Patient> patients = Arrays.asList(
			new Patient("id1", "Tuan", "Vietnamesisch"),
			new Patient("id2", "Tam", "Vietnamesisch")
			);
	@RequestMapping("/physicians")
	public EmployeesList getPhysicians() {
		EmployeesList employeesList = restTemplate.getForObject("http://hr-service/hr/employees", EmployeesList.class);
		
		return employeesList;
		
	}
	@RequestMapping("/diseases")
	public DiseasesList getDiseases() {
		DiseasesList diseasesList = restTemplate.getForObject("http://pathology-service/pathology/diseases", DiseasesList.class);
		
		return diseasesList;
	}
	
	
	@RequestMapping("/patients")
	public List<Patient> getPatients(){
		return patients;
	}
	@RequestMapping("/patients/{id}")	
	public Patient getPatientById(@PathVariable("id") String id) {
//		Patient p1=null;
		
		Patient p = patients.stream()
				.filter(patient -> id.equals(patient.getId()))
				.findAny()
				.orElse(null);
		
//		for (Patient patient: patients) {
//			if (patient.getId()==id) {
//				patient=p1;
//			} else
//				p1=null;
//		}
		return p;
	}
}
