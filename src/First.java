
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class First {
	

    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    
    	XSSFWorkbook ExcelWBook;
        XSSFSheet ExcelWSheet;
        XSSFCell Cell;
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://10.207.182.108:81/opencart/";
        String actualTitle = "";
        String Firstname="";
        String LastName="";
        String Email="";
        double Tel=0;
        String Address="";
        String city="";
        double Postcode=0; //chk to use int 
        String pwd="";
        String Cpwd="";
        	
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
       driver.findElement(By.xpath(".//*[@id='welcome']/a[2]")).click();
       String path = "C://Users//sthada//workspace//TopGear//src//TestData//RegistrationDetails.xlsx";
       String path1 = "C://Users//sthada//workspace//TopGear//src//TestData//output.txt";
       // To Register user by reading the data from excel 
      String sheetName = "Sheet1";
      try {
                                      
              FileInputStream ExcelFile = new FileInputStream(path);
              FileWriter fw = new FileWriter(path1);
      		
              ExcelWBook = new XSSFWorkbook(ExcelFile);
              ExcelWSheet = ExcelWBook.getSheet(sheetName);
        //    int  ExcelRow  = ExcelWSheet.getRow(0);
       //      int totalNoOfCols = ExcelRow.getLastCellNum();
           
                     	
          	for (int col = 0; col < 9; col++) //chk to get the total columns
          	{
	            Firstname = ExcelWSheet.getRow(1).getCell(0).getStringCellValue();
	            LastName=ExcelWSheet.getRow(1).getCell(1).getStringCellValue();
	            Email=  ExcelWSheet.getRow(1).getCell(2).getStringCellValue();
	            Tel= ExcelWSheet.getRow(1).getCell(3).getNumericCellValue();
	            Address= ExcelWSheet.getRow(1).getCell(4).getStringCellValue();
	            city= ExcelWSheet.getRow(1).getCell(5).getStringCellValue();
	            Postcode= ExcelWSheet.getRow(1).getCell(6).getNumericCellValue();
	            pwd= ExcelWSheet.getRow(1).getCell(9).getStringCellValue();
	            Cpwd= ExcelWSheet.getRow(1).getCell(10).getStringCellValue();
                                               
          	}
      
	     driver.findElement(By.xpath(".//*[@id='content']/form/div[1]/table/tbody/tr[1]/td[2]/input")).sendKeys( Firstname);
	     driver.findElement(By.xpath(".//*[@id='content']/form/div[1]/table/tbody/tr[2]/td[2]/input")).sendKeys( LastName);
	 	 driver.findElement(By.xpath(".//*[@id='content']/form/div[1]/table/tbody/tr[3]/td[2]/input")).sendKeys( Email);
	 	 driver.findElement(By.xpath(".//*[@id='content']/form/div[1]/table/tbody/tr[4]/td[2]/input")).sendKeys(String.valueOf(Tel));
	     driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/table/tbody/tr[5]/td[2]/input")).sendKeys( Address);
	     driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/table/tbody/tr[7]/td[2]/input")).sendKeys( city);
	     driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/table/tbody/tr[8]/td[2]/input")).sendKeys( String.valueOf(Postcode));
	     
	     //select from drop down
	     Select drpCountry = new Select(driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/table/tbody/tr[9]/td[2]/select")));
       	 drpCountry.selectByVisibleText("India");
       	 
	     Select drpState = new Select(driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/table/tbody/tr[10]/td[2]/select")));
      	 drpState.selectByVisibleText("Andhra Pradesh");
      	 
    	 driver.findElement(By.xpath(".//*[@id='content']/form/div[3]/table/tbody/tr[1]/td[2]/input")).sendKeys(pwd);
	     driver.findElement(By.xpath(".//*[@id='content']/form/div[3]/table/tbody/tr[2]/td[2]/input")).sendKeys(Cpwd);
	     driver.findElement(By.xpath(".//*[@id='content']/form/div[5]/div/input[1]")).click();
	     driver.findElement(By.xpath(".//*[@id='content']/form/div[5]/div/input[2]")).click();
	   
	     driver.findElement(By.xpath(".//*[@id='content']/p[4]/a")).click();
	     driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/textarea")).sendKeys("This is to Change of Address/Phone number");
	  //  driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/img"));
	     System.out.println("Please enter Captcha");
	     
	    Scanner sc = new Scanner(System.in); //To enter the captcha
		String captcha = sc.nextLine();
		driver.findElement(By.xpath("//*[@id='content']/form/div[2]/input[3]")).sendKeys(captcha); 
		driver.findElement(By.xpath(".//*[@id='content']/form/div[3]/div")).click();
		driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/a")).click();
		
		driver.findElement(By.xpath(".//*[@id='slideshow0']/a")).click();  //samsung image 
		driver.findElement(By.xpath(".//*[@id='tabs']/a[2]")).click();
		driver.findElement(By.xpath(".//*[@id='tab-review']/input[1]")).sendKeys("Suja");
		driver.findElement(By.xpath(".//*[@id='tab-review']/textarea")).sendKeys("GOODnkjtuyntyrhjngjnjkhkjguyjnuyhjnhbhgvbhjg");
		driver.findElement(By.xpath(".//*[@id='tab-review']/input[5]")).click();
		driver.manage().window().maximize();
		System.out.println("Please enter Captcha1");
		Scanner sc1 = new Scanner(System.in);
		String captcha1 = sc1.nextLine();
		
		driver.findElement(By.xpath(".//*[@id='tab-review']/input[7]")).sendKeys(captcha1); 
		
		driver.findElement(By.xpath(".//*[@id='button-review']")).click();
		driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/div[3]/div/span[2]/a[1]")).click();
		
		//driver.findElement(By.xpath(".//*[@id='notification']/div/img")).click();
		
		
	
		
		WebElement element=driver.findElement(By.xpath(".//*[@id='wishlist-total']")); //org.openqa.selenium.WebDriverException: unknown error: Element <a href="http://10.207.182.108:81/opencart/index.php?route=account/wishlist" id="wishlist-total">...</a> is not clickable at point (878, 7). Other element would receive the click: <div class="price">...</div>
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		//driver.manage().window().maximize();
	
		//After wish list
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/a[2]	")).click(); //pound
		String Pound=	driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[2]/div[2]")).getText();
		System.out.println("Value in Pound is " + Pound );
		fw.write("Value in Pound is" + Pound );
	     fw.append(System.lineSeparator());
  		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/a[1]")).click(); //Euro
		String Euro=driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[2]/div[2]")).getText();
		System.out.println("Value in Euro is " + Euro);
		
		fw.append("Value in Euro is " + Euro);
		  fw.append(System.lineSeparator());
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/a[3]")).click(); //dollar
		String dollar=driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[2]/div[2]")).getText();
		System.out.println("Value in dollar is " + dollar);
		fw.append("Value in dollar is " + dollar);
		  fw.append(System.lineSeparator());
		
		fw.close();
		driver.findElement(By.id("button-cart")).click(); //Add to cart 
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".close")).click(); //close sucess message 
	
		//driver.findElement(By.xpath(".//*[@id='wishlist-row49']/tr/td[6]/a/img")).click(); //To remove the item
		//driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/a")).click();
	//	driver.findElement(By.xpath(".//*[@id='welcome']/a[2]")).click();  //logout
       }
     
            
      
      catch (Exception e) {
          
    	  		e.printStackTrace();
          
      }
      
        //close Fire fox
       // driver.close();
   
}
}
