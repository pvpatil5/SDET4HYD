package com.crm.Vtiger.GenericPac;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class helps to read data from Prop file it has 2 methods
 * @author AMAR-G
 *
 */
public class FileUtils 
{
	/**
	 * This method read the data from prop file
	 * @param key
	 * @return value from prop file
	 * @throws IOException
	 */

	public String readDatafromPropfile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IAutoConstants.propfilepath);

		Properties prop  = new  Properties();
		prop.load(fis);

		return prop.getProperty(key);

	}
	public String readDatafromPropfile(String path,String key) throws IOException {
		FileInputStream fis = new FileInputStream(path);

		Properties prop  = new  Properties();
		prop.load(fis);

		return prop.getProperty(key);

	}


}
