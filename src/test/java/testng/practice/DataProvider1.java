package testng.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1
{
	@Test(dataProvider = "city")
	public void travel(String src, String dest, String stop) {
		System.out.println(src +" "+dest +" "+stop);
	}


	@DataProvider
	public Object[][] city() {
		
		Object arr[][]= new Object[4][3];

		arr[0][0]="hyd";
		arr[0][1]="blr";
		arr[0][2]="zahirabad";
		
		arr[1][0]="pune";
		arr[1][1]="mumbai";
		arr[1][2]="Maval";

		arr[2][0]="amravati";
		arr[2][1]="hyd";
		arr[2][2]="guntur";

		arr[3][0]="vijayvada";
		arr[3][1]="hyd";
		arr[3][2]="suryapet";

		return arr;

	}


}
