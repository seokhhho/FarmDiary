package com.ssafy.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.test.Customer;
import com.ssafy.test.model.Diagnosis;
import com.ssafy.test.model.DiagnosisRepository;
import com.ssafy.test.model.Pests;
import com.ssafy.test.model.PestsRepository;

@RestController
@RequestMapping("/pests")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PestsController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private PestsRepository pestsRepository;
	
	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
	@GetMapping("/{cropName}")
	public ResponseEntity<List<Pests>> searchPests(@PathVariable("cropName") String cropName) throws Exception{
		return new ResponseEntity<List<Pests>>(pestsRepository.findByCropName(cropName), HttpStatus.OK);
	}
	
	@GetMapping("/detail/{cropName}/{pestName}")
	public ResponseEntity<List<Pests>> searchCrop(@PathVariable("pestName") String pestName, @PathVariable("cropName") String cropName) throws Exception{
		return new ResponseEntity<List<Pests>>(pestsRepository.findByPestNameAndCropName(pestName,cropName), HttpStatus.OK);
	}
	
	@PostMapping("/diagnose")
	public ResponseEntity<Diagnosis> diagnoseCrop(
			@RequestParam("cropName") String cropName,
			@RequestPart("photo") MultipartFile sourceFile) throws Exception{
		
		String sourceFileName = sourceFile.getOriginalFilename();
		String sourceFileNameExtension = StringUtils.getFilenameExtension(sourceFileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
//		byte[] bytes;
//		bytes = sourceFile.getBytes();
////		destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;
//		System.out.println(sourceFileNameExtension);
//		Blob blob = new SerialBlob(bytes);
//		System.out.println(blob);
//		
//		Diagnosis test = new Diagnosis(cropName, blob, "test");
//		
//		diagnosisRepository.insert(Arrays.asList(test));
//		
//		System.out.println(diagnosisRepository.findByCropName("django.png"));
//		
//		System.out.println("!!!");
		
		destinationFileName = cropName + "." + sourceFileNameExtension;
		System.out.println(destinationFileName);
		destinationFile = new File("C:/ssafy/Project3/" + destinationFileName);
        if(!destinationFile.exists())
        	destinationFile.getParentFile().mkdirs();
        sourceFile.transferTo(destinationFile);
        
        byte [] image = new byte[ (int) destinationFile.length() ];
        FileInputStream fis = new FileInputStream( destinationFile );
        fis.read(image);
        String base64EncodedImage = "data: image/png;base64," + new String (Base64.encodeBase64 (image), StandardCharsets.US_ASCII);
		Diagnosis test = new Diagnosis(cropName, base64EncodedImage, "검은무늬병");
		
		diagnosisRepository.insert(Arrays.asList(test));
		
		return new ResponseEntity<Diagnosis>(diagnosisRepository.findByCropName(cropName), HttpStatus.OK);
	}
}
