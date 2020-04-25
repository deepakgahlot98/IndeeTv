package com.gahlot.indeetv.model;

import java.io.Serializable;

public class TestDataDTO implements Serializable {
	private String id;
	private String name;
	private String paymentPlan;
	private String releaseYear;
	private String videoDuration;
	private String type;
	private String createdOn;
	private String updatedOn;
	private String posterLink;
	private String shortDescription;
	private String description;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPaymentPlan(String paymentPlan){
		this.paymentPlan = paymentPlan;
	}

	public String getPaymentPlan(){
		return paymentPlan;
	}

	public void setReleaseYear(String releaseYear){
		this.releaseYear = releaseYear;
	}

	public String getReleaseYear(){
		return releaseYear;
	}

	public void setVideoDuration(String videoDuration){
		this.videoDuration = videoDuration;
	}

	public String getVideoDuration(){
		return videoDuration;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setCreatedOn(String createdOn){
		this.createdOn = createdOn;
	}

	public String getCreatedOn(){
		return createdOn;
	}

	public void setUpdatedOn(String updatedOn){
		this.updatedOn = updatedOn;
	}

	public String getUpdatedOn(){
		return updatedOn;
	}

	public void setPosterLink(String posterLink){
		this.posterLink = posterLink;
	}

	public String getPosterLink(){
		return posterLink;
	}

	public void setShortDescription(String shortDescription){
		this.shortDescription = shortDescription;
	}

	public String getShortDescription(){
		return shortDescription;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"TestDataDTO{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",payment_plan = '" + paymentPlan + '\'' + 
			",release_year = '" + releaseYear + '\'' + 
			",video_duration = '" + videoDuration + '\'' + 
			",type = '" + type + '\'' + 
			",created_on = '" + createdOn + '\'' + 
			",updated_on = '" + updatedOn + '\'' + 
			",posterLink = '" + posterLink + '\'' + 
			",shortDescription = '" + shortDescription + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}