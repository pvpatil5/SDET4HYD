package testng.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_1 extends Base
{

	 @Test(priority = 1)
	 public void A() {
		 System.out.println("A running from Class TestNG_1");
		// Assert.assertFalse(true);
	 }
	 
	 @Test()
	 public void B() {
		 System.out.println("B running from Class TestNG_1");
	 }
	 @Test()
	 public void C() {
		 System.out.println("c running from Class TestNG_1");
	 }
}
