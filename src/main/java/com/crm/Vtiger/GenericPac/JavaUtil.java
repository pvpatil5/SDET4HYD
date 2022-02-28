package com.crm.Vtiger.GenericPac;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtil {

	/**
	 * @author AMAR-G
	 * This method is going to generate a random number.
	 * @return random number till 100
	 */
	public int generateRandomNumber() 
	{
	Random random = new Random();
	return random.nextInt(100);
	}
	/**
	 * This Method is going to generate fake first name
	 * @return first name
	 */
	public String fakefirstName() 
	{
		Faker faker = new Faker();
		return faker.name().firstName();
	}
	
	/**
	 * This Method is going to generate fake last name
	 * @return last name
	 */
	
	public String fakelastName() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}
	/**
	 * This Method is gone generate Fake Address
	 * @return fake address
	 */
	public String fakeAddress() {
		Faker faker = new Faker();
		return  faker.address().fullAddress();
	}
	/**
	 * @author AMAR-G
	 * This Method is gonna generate Fake company name
	 * @return fake company name
	 */
	
	public String fakecompanyName() {
		Faker faker = new Faker();
		return faker.company().name();
	}
	

}
