package com.gahlot.indeetv.model;

import java.util.List;
import java.io.Serializable;

public class ResponseDTO implements Serializable {
	private List<TestDataDTO> testData;

	public void setTestData(List<TestDataDTO> testData){
		this.testData = testData;
	}

	public List<TestDataDTO> getTestData(){
		return testData;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"testData = '" + testData + '\'' + 
			"}";
		}
}