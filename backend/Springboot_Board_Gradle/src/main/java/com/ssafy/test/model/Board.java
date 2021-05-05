package com.ssafy.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Document(collection = "board")
public class Board {

	@Id
	private String id;
	private String title;
	private String contents;
	private String date;
	
	@Builder
	public Board(int bId, String title, String contents, String date) {
		this.title = title;
		this.contents = contents;
		this.date = date;
	}
	

	
	
	
}
