package com.autodesk.agiledemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWeatherAdvice {
	private final Weather weather = new Weather();
	
	@Test
	public void shirt_when_temp_between_60_and_69_and_condition_sunny() {
		assertWearingAdviceEquals("Shirts", "Sunny", 60d); 
		assertWearingAdviceEquals("Shirts", "Sunny", 69d); 
	}
	
	@Test
	public void Tshirt_when_temp_between_70_and_79_and_condition_sunny() {
		assertWearingAdviceEquals("T-shirt", "Sunny", 70d); 
		assertWearingAdviceEquals("T-shirt", "Sunny", 79d); 
	}
	
	@Test
	public void raincoat_when_temp_between_60_and_69_and_condition_raining(){
		assertWearingAdviceEquals("Raincoat", "Raining", 60d); 
		assertWearingAdviceEquals("Raincoat", "Raining", 69d); 
	}
	
	@Test
	public void umbrella_and_TShirt_when_temp_between_70_and_79_and_condition_raining(){
		assertWearingAdviceEquals("Umbrella, T-shirt", "Raining", 70d); 
		assertWearingAdviceEquals("Umbrella, T-shirt", "Raining", 79d); 
	}
	
	@Test
	public void no_advice_when_temp_out_of_range(){
		assertWearingAdviceEquals("No Advice", "Raining", 59d); 		
		assertWearingAdviceEquals("No Advice", "Sunny", 80d); 		
	}
	
	@Test
	public void no_advice_when_condition_uncovered(){
		assertWearingAdviceEquals("No Advice", "Cloudy", 65d); 		
			
	}
	
	
	private void assertWearingAdviceEquals(String expectedWearingAdvice, String condition, double temperature) {
		weather.setCondition(condition);
		weather.setTemperature(temperature);
		String actualWearingAdvice = weather.getWearingAdvice();
		assertEquals(expectedWearingAdvice, actualWearingAdvice);
	}

}
