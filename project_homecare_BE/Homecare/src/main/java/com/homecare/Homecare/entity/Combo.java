package com.homecare.Homecare.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "combo")
public class Combo {

	@Id
	private String id ;
	
	@NotBlank
	private String name;

	@NotBlank
	private String price;
	
	@NotBlank
	private String time ;
	
	@NotBlank
	private String information ;
}



