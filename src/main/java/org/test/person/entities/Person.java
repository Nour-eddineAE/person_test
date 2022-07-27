package org.test.person.entities;

import java.io.Serializable;

import org.neo4j.driver.internal.shaded.reactor.util.annotation.NonNull;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String gender;
	@NonNull
	private String email;
	@NonNull
	private String phone;
	@NonNull
	private String adresse;
	

	/**
	 *default constructor 
	 */
	public Person() {
		super();
	}
	/**
	 *constructor with parameters 
	 */
	public Person(String name, String gender, String email, String phone, String adresse) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.adresse = adresse;
	}
	/**
	 * getters and setters
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
