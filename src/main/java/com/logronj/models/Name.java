package com.logronj.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "NAME")
public abstract class Name {
	
	@NotBlank(message = "FirstName is required")
	@Size(min = 3, max = 20)
	@Column(name="FIRST_NAME")
	private String firstName;
	@NotBlank(message = "MiddleName is required")
	@Size(min = 3, max = 20)
	@Column(name="MIDDLE_NAME")
	private String middleName;
	@NotBlank(message = "LastName is required")
	@Size(min = 3, max = 20)
	@Column(name="LAST_NAME")
	private String lastName;
	
	public Name() {
		super();
	}
	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ninong [firstName=");
		builder.append(firstName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append("]");
		return builder.toString();
	}
}
