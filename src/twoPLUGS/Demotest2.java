package twoPLUGS;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demotest2 {
	private WebDriver driver;
	private String baseurl;
	
  @BeforeMethod
  public void setup() {
	  System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver-v0.24.0\\geckodriver.exe");
	  baseurl="https://www.twoplugs.com/";
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  driver.get(baseurl);
    }
  
  @Test
  public void verifyinvalidLogin() {
	  driver.findElement(By.xpath("html/body/div[1]/header/div/ul/li[1]/a")).click();
	  driver.findElement(By.xpath("//input[@id='signInEmail']")).sendKeys("Naresh_rp");
	  driver.findElement(By.xpath("//input[@id='signInPassword']")).sendKeys("Naresh123");
	  driver.findElement(By.xpath("//button[contains(.,'LOG IN')]")).click();
	  
	  WebElement text = null;
		  try 
		  	{
			text = driver.findElement(By.xpath("//span[text()='Hi,naresh_rp']"));
		  	}
	  	  catch(NoSuchElementException e)
		  	{
	  		  System.out.println(e.getMessage());
		  	}
	 Assert.assertTrue(text != null);
  }
  
  @AfterMethod
  public void teardown(){
	 
	  driver.quit();
 }
}
  
