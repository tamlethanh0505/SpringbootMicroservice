package com.tuanbong2000.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuanbong2000.pathologyservice.models.Disease;
import com.tuanbong2000.pathologyservice.models.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {
	
	List<Disease> diseases = Arrays.asList(
			new Disease("d1", "hoi nach"),
			new Disease("d2", "hoi chan")
			);
	
	@RequestMapping("/diseases")
	public DiseasesList getDiseases(){
		DiseasesList diseasesList = new DiseasesList();
		diseasesList.setDiseases(diseases);
		return diseasesList;
	}
	
	@RequestMapping("/diseases/{id}")
	public Disease getDiseaseById(@PathVariable("id") String id){
		
		Disease d = diseases.stream()
				.filter(disease -> id.equals(disease.getId()))
				.findAny()
				.orElse(null);
		
		return d;
	}
	

}
