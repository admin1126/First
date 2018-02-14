package topGear_New;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

	public static void main(String[] args) {
		
		System.out.println("Finding all links ");
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String baseUrl = "http://10.207.182.108:81/opencart/";
			driver.get(baseUrl);
			driver.findElement(By.xpath("/html/body/div/div[1]/div[4]/a[1]")).click();
			driver.findElement(By.name("email")).sendKeys("sujanaren414.thada@gmail.com");
			driver.findElement(By.name("password")).sendKeys("ABCD");
			driver.findElement(By.xpath("/html/body/div/div[5]/div[2]/div[2]/form/div/input[3]")).click();
			
			List<WebElement>  elementList = new ArrayList();
				
			elementList= driver.findElements(By.tagName("a"));
			int i =elementList.size();
			System.out.println(i);
			//elementList.addAll(driver.findElements(By.tagName("img")));

			  List finalList = new ArrayList();
			  for (WebElement element : elementList)
				  
			  {
				  if(element.getAttribute("href") != null)
		 
				  {
		 			  finalList.add(element);
					  System.out.println("URL: " + element.getAttribute("href"));
		 
				  }		  
		 
			  }
	}

}
