package com.autodesk.agiledemo;

import java.util.HashMap;
import java.util.Map;

public class Weather {
	private String city;
	private String region;
	private String country;
	private double temperature;
	private String condition;
	private String humidity;
	private String windSpeed;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) { 
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWearingAdvice() {
		Map<String,String> mapWearingAdvice = new HashMap<>();
		mapWearingAdvice.put("truetrue","Umbrella, T-shirt" );
		mapWearingAdvice.put("truefalse","T-shirt" );
		mapWearingAdvice.put("falsetrue","Raincoat" );
		mapWearingAdvice.put("falsefalse","Shirts" );
		if (isTempOutOfRange() || isConditionUncovered())
			return "No Advice";
		return mapWearingAdvice.get(getKeyOfWearingAdvice());
	}
	private String getKeyOfWearingAdvice() {
		return String.valueOf(isHot())+this.condition.equals("Raining");
	}
	private boolean isConditionUncovered() {
		return !this.condition.equals("Sunny") && !this.condition.equals("Raining");
	}
	private boolean isTempOutOfRange() {
		return this.temperature<60 || this.temperature>79;
	}
	private boolean isHot() {
		return this.temperature>=70 && this.temperature<=79;
	}	
}