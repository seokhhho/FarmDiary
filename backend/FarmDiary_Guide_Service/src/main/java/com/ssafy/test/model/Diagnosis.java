package com.ssafy.test.model;


import java.sql.Blob;

import javax.persistence.*;
import org.springframework.data.mongodb.core.mapping.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Document(collection = "diagnosis")

public class Diagnosis {
	@Id
	private String id;
	private String cropName;
	private String img;
	private String result;
	
	public Diagnosis(String cropName, String img, String result) {
		super();
		this.cropName = cropName;
		this.img = img;
		this.result = result;
	}
	
}
