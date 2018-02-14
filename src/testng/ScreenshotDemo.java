package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ScreenshotDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
            driver.get("http://google.com");
            driver.manage().window().maximize();
            System.out.println(driver.getTitle());

         try{
                //take screenshot and save it in a file
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

                //copy the file to the required path
                FileUtils.copyFile(screenshot,new File("C://Users//sthada//workspace//TopGear//src//TestData//screenshot.png"));

            }
         catch(Exception e){
                //if it fails to take screenshot then this block will execute
                System.out.println("Failure to take screenshot "+e);
         }  
    }
}