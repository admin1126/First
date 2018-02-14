package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class NewTest {
  
  
 // System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	@Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
	
	
  @BeforeMethod
  public void beforeMethod() {
	  String baseUrl = "http://10.207.182.108:81/opencart/";
		driver.get(baseUrl);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
	  Object[][] data =new Object[2][2];
	  data[0][0]="first";
			  data[0][1]="pwd1";
			  
			  data[1][0]="second";
			  data[1][1]="pwd2";
			  
    return data;
     
    
  }
}
