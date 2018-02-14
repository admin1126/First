package topGear_New;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class ProductComparison {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Testing new");
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String baseUrl = "http://10.207.182.108:81/opencart/";
			driver.get(baseUrl);
			driver.findElement(By.xpath("/html/body/div/div[1]/div[4]/a[1]")).click();
			driver.findElement(By.name("email")).sendKeys("sujanaren414.thada@gmail.com");
			driver.findElement(By.name("password")).sendKeys("ABCD");
			driver.findElement(By.xpath("/html/body/div/div[5]/div[2]/div[2]/form/div/input[3]")).click();
			
			WebElement search=driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/input"));
			search.sendKeys("apple");
			search.sendKeys(Keys.RETURN);
			//TakesScreenshot scrShot =((TakesScreenshot)driver);
			
			
			Select drop_down =new Select(driver.findElement(By.name("category_id")));
			drop_down.selectByValue("28");
			
			driver.findElement(By.id("sub_category")).click();

			driver.findElement(By.id("button-search")).click();
			
			driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[6]/a")).click();
			
			Select phones =new Select(driver.findElement(By.xpath("/html/body/div/div[5]/div[2]/div[3]/select")));
			phones.selectByVisibleText("Price (High > Low)");
			
			driver.findElement(By.xpath("/html/body/div/div[5]/div[4]/div[1]/div[1]/div[3]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div[5]/div[4]/div[2]/div[1]/div[3]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div[5]/div[4]/div[3]/div[1]/div[3]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='compare-total']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div[4]/table/tbody[1]/tr[1]/td[2]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='button-cart']")).click();
			//shopping cart click
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/a[2]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[5]/div[1]/a']")).click();
			
			Thread.sleep(2000);
			//2
			driver.findElement(By.xpath("//*[@id=button-payment-address']")).click();
			driver.findElement(By.xpath("//*[@id=button-shipping-addres]")).click();
			driver.findElement(By.xpath("//*[@id'=button-shipping-method]")).click();
			Thread.sleep(2000);
			//terms n conditions
			driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[5]/div[2]/div/div/input[1]")).click();
			driver.findElement(By.id("button-payment-method"));
			driver.findElement(By.id("button-confirm"));
			
	}
	

}
