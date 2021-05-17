package com.ssafy.test.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.test.Customer;
import com.ssafy.test.model.Guide;
import com.ssafy.test.model.GuideRepository;


@RestController
@RequestMapping("/guide")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GuideController {
	
	@Autowired
	private GuideRepository guideRepository;
	
	@GetMapping("/{place}")
	public ResponseEntity<List<Guide>> searchCrops(@PathVariable("place") String place) throws Exception{
		System.out.println(place);
		
		Guide guide1 = new Guide("1", "2","3","4","5","6","7","8");
		
		guideRepository.insert(Arrays.asList(guide1));
		System.out.println(guideRepository.readByPlace("2"));
		
		System.out.println(guideRepository.findAll());
		return new ResponseEntity<List<Guide>>(guideRepository.findByPlace("2"), HttpStatus.OK);
	}
	
	@GetMapping("/crop/{name}")
	public ResponseEntity<Guide> searchCrop(@PathVariable("name") String name) throws Exception{
		System.out.println(name);
		System.out.println(guideRepository.findByName(name));
		return new ResponseEntity<Guide>(guideRepository.findByName(name), HttpStatus.OK);
	}
	
}
