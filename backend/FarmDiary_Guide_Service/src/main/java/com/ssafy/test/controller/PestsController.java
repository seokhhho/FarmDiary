package com.ssafy.test.controller;

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

import com.ssafy.test.model.Pests;
import com.ssafy.test.model.PestsRepository;


@RestController
@RequestMapping("/pests")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PestsController {
	
	@Autowired
	private PestsRepository pestsRepository;
	
	@GetMapping("/{cropName}")
	public ResponseEntity<List<Pests>> searchPests(@PathVariable("cropName") String cropName) throws Exception{
		return new ResponseEntity<List<Pests>>(pestsRepository.findByCropName(cropName), HttpStatus.OK);
	}
	
	@GetMapping("/detail/{cropName}/{pestName}")
	public ResponseEntity<List<Pests>> searchCrop(@PathVariable("pestName") String pestName, @PathVariable("cropName") String cropName) throws Exception{
		return new ResponseEntity<List<Pests>>(pestsRepository.findByPestNameAndCropName(pestName,cropName), HttpStatus.OK);
	}
	
}
