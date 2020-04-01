package day2Assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		//Open the Chrome Driver
		ChromeDriver dr = new ChromeDriver();
		
		//Print the Browser name
		dr.getCapabilities().getBrowserName();
		
		//Hitting the TestLeaf URL
		dr.get("http://leaftaps.com/opentaps/control/main");
		
		//Enter the user name
		WebElement uName = dr.findElementById("username");
		uName.sendKeys("DemoSalesManager");
		
		//Enter Password
		WebElement pwd = dr.findElementById("password");
		pwd.sendKeys("crmsfa");
		
		//Click Login button
		WebElement login = dr.findElementByClassName("decorativeSubmit");
		login.click();
		
		Thread.sleep(2000);
		
		//Navigate to the CRM/SFA page
		WebElement crmPage = dr.findElementByLinkText("CRM/SFA");
		crmPage.click();
		
		Thread.sleep(2000);
		
		//Navigate to the Create Lead page
		WebElement createLead = dr.findElementByLinkText("Create Lead");
		createLead.click();
		
		Thread.sleep(5000);
		
		//Print the Title of the page
		String pageTitle = dr.getTitle();
		System.out.println("Title of the page : "+"   "+pageTitle);
		
		// Opentaps CRMSFA Login - Create new Lead with Company Name, First Name, Last Name
		
		dr.findElementById("createLeadForm_companyName").sendKeys("TCS");
		dr.findElementById("createLeadForm_firstName").sendKeys("Raja");
		dr.findElementById("createLeadForm_lastName").sendKeys("Sekaran");
		dr.findElementByName("submitButton").click();
		
		System.out.println("Lead page : "+"   "+dr.getTitle());
		
		dr.close();
		
	}

}
