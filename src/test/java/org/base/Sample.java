package org.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sample extends BaseClass {

	public static void main(String[] args) {
		
		
		getdriver("chrome");
		
		loadUrl("http://demo.automationtesting.in/Register.html");
		
		
		fill(driver.findElement(By.xpath("//input[@placeholder='First Name']")), "pk");
		fill(driver.findElement(By.xpath("//input[@placeholder='Last Name']")), "pk");
		
		fill(driver.findElement(By.xpath("//textarea[@ng-model='Adress']")), "pk");
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
