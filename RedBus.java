package day5Testcase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		
		//Open the Chrome Driver
		ChromeDriver dr = new ChromeDriver();
		
		//Maximize the browser
		dr.manage().window().maximize();
		
		//Implicit wait for the Element wait
		dr.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//Hitting the ACME site URL
		dr.get("https://www.redbus.in/");
		
		//Enter the From Location
		dr.findElementById("src").sendKeys("Chennai");
		
		Thread.sleep(2000);
		
		//Enter the To Location
		dr.findElementById("dest").sendKeys("Bangalore");
		
		Thread.sleep(2000);
		
		dr.findElementById("dest").sendKeys(Keys.TAB);
		
		//Select Onwards Journey date
		dr.findElement(By.xpath("(//td[text()='30'])[2]")).click();
		
		//Search button
		dr.findElementById("search_btn").click();
		
		//Return the Filter criteria label		
		WebElement lableDepar = dr.findElementByXPath("//div[text()='DEPARTURE TIME']");
		System.out.println(lableDepar.getText());
		
		//Departure Time selection criteria
		dr.findElement(By.xpath("(//label[text()='6 am to 12 pm'])[1]")).click();
			
		Thread.sleep(2000);
		
		//Check whether Departure Time 6Am is selected or not
		if(dr.findElementById("dt6 am to 12 pm").isSelected()) 
			{
				System.out.println("departure time 6AM is selected");
			}
		else
			{
				System.out.println("Not selected");
			}
		
		//Bus Type Filter criteria
		WebElement lableBus = dr.findElementByXPath("//div[text()='BUS TYPES']");
		System.out.println(lableBus.getText());
		dr.findElementByXPath("//label[@title='SLEEPER']").click();
					
		Thread.sleep(2000);
		//Check whether Bus Type Sleeper is selected or not
		if(dr.findElementById("bt_SLEEPER").isSelected())
			{
				System.out.println("Bus Type Sleeper is selected");}
		else
			{
				System.out.println("Bus Type is selected other than Sleeper");
			}
		
		//Sort based on the Seats Available		
		dr.findElement(By.xpath("(//div[contains(@class,'w-15 fl')]//a)[2]")).click();
		
		//Close the browser
		dr.close();
	
		}

}
