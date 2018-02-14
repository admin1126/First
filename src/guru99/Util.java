package guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Util {

	
	public static WebDriver Initialize()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 String baseUrl = "http://www.demo.guru99.com/V4/";
		 driver.get(baseUrl);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 return driver;
		
	}
		
	}


