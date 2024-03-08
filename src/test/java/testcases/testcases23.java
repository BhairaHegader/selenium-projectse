package testcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.XLUtility;

public class testcases23
{ 
	
	WebDriver driver;
	
	@Test(priority=1)
	public void test() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
	    driver=new FirefoxDriver();
	    WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://e2e.cloudtesla.com/");
	    driver.manage().window().maximize();
	    
	    mywait.withTimeout(Duration.ofSeconds(4000));
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Sign up']")).click();
		
		String File="C:\\eclipseworkse\\cloudteslaproject\\src\\test\\resources\\testdata\\Testdata2023.xlsx.xlsx";
		int rows=XLUtility.getrowCount(File, "Sign up");
		for(int i=1; i<=rows; i++)
		{
			//reading  data from first row
			String fname=XLUtility.getcelldata(File, "Sign up", i, 0);
			
			String lname=XLUtility.getcelldata(File, "Sign up", i, 1);
			String mobileno=XLUtility.getcelldata(File, "Sign up", i, 2);
			String email=XLUtility.getcelldata(File, "Sign up", i, 3);
			String username=XLUtility.getcelldata(File, "Sign up", i, 4);
			String pwd=XLUtility.getcelldata(File, "Sign up", i, 5);
			String description=XLUtility.getcelldata(File, "Sign up", i, 6);
		
	
            //pass data to application 
	        driver.findElement(By.id("firstName")).sendKeys(fname);
	        driver.findElement(By.id("lastName")).sendKeys(lname);
	        driver.findElement(By.id("mobile")).sendKeys(mobileno);
	        driver.findElement(By.id("email")).sendKeys(email);
	        driver.findElement(By.id("username")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(pwd);
	        driver.findElement(By.id("desc")).sendKeys(description); 
	        
	        driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
	        mywait.withTimeout(Duration.ofSeconds(4));
	        String text=driver.findElement(By.xpath("//span[@class='ng-binding']")).getText();
		    System.out.println(text);
		    mywait.withTimeout(Duration.ofSeconds(4));
	      
	        driver.findElement(By.xpath("//span[@class='ng-binding']")).click();
	        mywait.withTimeout(Duration.ofSeconds(3));
	        
	        driver.findElement(By.xpath("//a[normalize-space()='Signout']")).click();
	        mywait.withTimeout(Duration.ofSeconds(4));
	        
	        
	     
			String File1="C:\\eclipseworkse\\cloudteslaproject\\src\\test\\resources\\testdata\\Testdata2023.xlsx.xlsx";
					
			int rows1=XLUtility.getrowCount(File1, "login");
			
			for(int j=1; j<=rows1; j++)
			{
				try 
				{
					//reading from excel sheet
		            String email1=XLUtility.getcelldata(File1, "login", j, 0);
					
					String password=XLUtility.getcelldata(File1, "login", j, 1);
					
					//send data to Webpages
				    driver.findElement(By.id("username")).sendKeys(email1);
					driver.findElement(By.id("password")).sendKeys(password);
					driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
					
					
					
					
						String textuser=driver.findElement(By.xpath("//span[@class='ng-binding']")).getText();
						System.out.println(textuser);
					if(textuser.equals("testuser"))
						
					{
						XLUtility.setcelldata(File1, "login",j, 2, "Passed");
					}
					else
					{
						XLUtility.setcelldata(File1, "login",j, 2, "failed");
					}
		
					
					
				}
				  catch(Exception e)
				{
					  System.out.println("test failed");
					  driver.close();
					  
				}
				
				System.out.println("test completed");
				driver.findElement(By.id("username")).clear();
		          
				driver.findElement(By.xpath("//input[@id='password']")).clear();
			
			}   
			
		}
	}
}
	



