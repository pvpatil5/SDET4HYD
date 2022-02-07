package practice_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	public static void main(String[] args) throws IOException {
		
	
	FileInputStream fis = new FileInputStream("D:\\April2021\\com.crm.Vtiger\\commondata.properties");

	Properties prop = new Properties();
	prop.load(fis);
	String value=(String) prop.get("UN");
	System.out.println(value);
	
	
	
	}
}
