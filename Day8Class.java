package Day8;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day8Class {

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
		
		//First Drop down Select
		//Select the Source Drop down using Id
		WebElement findElementById = dr.findElementById("createLeadForm_dataSourceId");
		//Select Keyword is used for the drop down
		Select sel = new Select(findElementById);
		//Selecting value based on the Visible text
		sel.selectByVisibleText("Cold Call");
		
		
		//Second Drop down to pick the last one in the drop down
		//Create Object based on the Id
		WebElement indId = dr.findElementById("createLeadForm_industryEnumId");
		//Select Keyword is used for the Option
		Select sel1 = new Select(indId);
		//Select options 
		List<WebElement> options = sel1.getOptions();
		//Count the options
		int size = options.size();
		//Select the last options
		sel1.selectByIndex(size-1);
		
/*
		
		//Print the Title of the page
		String pageTitle = dr.getTitle();
		System.out.println("Title of the page : "+"   "+pageTitle);
		
		
		// Opentaps CRMSFA Login - Create new Lead with Company Name, First Name, Last Name
		
		dr.findElementById("createLeadForm_companyName").sendKeys("TCS");
		dr.findElementById("createLeadForm_firstName").sendKeys("Raja");
		dr.findElementById("createLeadForm_lastName").sendKeys("Sekaran");
		dr.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("1234567890");
		dr.findElementByName("submitButton").click();
		
		System.out.println("Lead page : "+"   "+dr.getTitle());
		
		dr.close();
		
		*/
		
		

	}

}
