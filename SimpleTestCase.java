package day5Testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SimpleTestCase {

	public static void main(String[] args) {
		
		//Open the Chrome Driver
		ChromeDriver dr = new ChromeDriver();
		
		//Maximize the browser
		dr.manage().window().maximize();
		
		//Implicit wait for the Element wait
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//Hitting the ACME site URL
		dr.get("https://acme-test.uipath.com/account/login");
				
		//Enter the User Name
		dr.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		
		//Enter the Password
		dr.findElementById("password").sendKeys("leaf@12");
		
		//Click Login button
		dr.findElementById("buttonLogin").click();
		
			
		//Mouse over on the Vendor menu
		WebElement Vmouse = dr.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
		Actions builder = new Actions(dr);
		builder.moveToElement(Vmouse).perform();
		
		//Navigate to the search vendor page
		WebElement sVendor = dr.findElementByXPath("//a[@href='/vendors/search']");
		sVendor.click();
		
		//Entered Vendor Name
		dr.findElementById("vendorName").sendKeys("Blue Lagoon");
		
		//CLick on the Search button
		dr.findElementById("buttonSearch").click();
		
		//Return the Country of the Vendor Name
		String country = dr.findElementByXPath("//table[@class='table']/tbody[1]/tr[2]/td[5]").getText();
		System.out.println(country);
		
		//Logout
		//dr.findElementByXPath("//a[@href='/account/logout/']").click();
		
		dr.findElementByLinkText("Log Out").click();
		
		//Close browser
		dr.close();
		
		}

}
