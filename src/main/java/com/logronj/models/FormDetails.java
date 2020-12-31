package com.logronj.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FormDetails {
	
	@Valid
	private Inaanak inaanak;
	@Valid
	private Ninong ninong;
	private Education education;
	@NotBlank
	private String favoriteFoodAndDrinks;
	@NotBlank
	private String isNinongKind;
	
	public Inaanak getInaanak() {
		return inaanak;
	}
	public void setInaanak(Inaanak inaanak) {
		this.inaanak = inaanak;
	}
	public Ninong getNinong() {
		return ninong;
	}
	public void setNinong(Ninong ninong) {
		this.ninong = ninong;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public String getFavoriteFoodAndDrinks() {
		return favoriteFoodAndDrinks;
	}
	public void setFavoriteFoodAndDrinks(String favoriteFoodAndDrinks) {
		this.favoriteFoodAndDrinks = favoriteFoodAndDrinks;
	}
	public String getIsNinongKind() {
		return isNinongKind;
	}
	public void setIsNinongKind(String isNinongKind) {
		this.isNinongKind = isNinongKind;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FormDetails [inaanak=");
		builder.append(inaanak);
		builder.append(", ninong=");
		builder.append(ninong);
		builder.append(", education=");
		builder.append(education);
		builder.append(", favoriteFoodAndDrinks=");
		builder.append(favoriteFoodAndDrinks);
		builder.append(", isNinongKind=");
		builder.append(isNinongKind);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
