package firstWeekend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAssignment {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver dr = new ChromeDriver();
		
		dr.manage().window().maximize();
		
		//Launch the TestLeaf website
		dr.get("http://leaftaps.com/opentaps/control/main");
		
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement leafLogo = dr.findElementById("logo");
		leafLogo.getText();
		
		
		System.out.println(dr.findElementByXPath("//div[@id='form']/h2").getText());
		
		//Enter the user name
		WebElement uName = dr.findElementById("username");
		uName.sendKeys("DemoSalesManager");
		
		//Enter Password
		WebElement pwd = dr.findElementById("password");
		pwd.sendKeys("crmsfa");
		
		//Click Login button
		WebElement login = dr.findElementByClassName("decorativeSubmit");
		login.click();
		
		System.out.println("Logged In Successful");
		
		//Navigate to CRM Page
		dr.findElementByLinkText("CRM/SFA").click();
		
		//Navigate to the My Lead Page
		dr.findElementByXPath("//a[text()='Leads']").click();
		
		//Navigate to Find Leads page
		dr.findElementByXPath("//a[text()='Find Leads']").click();
		
		Thread.sleep(3000);
		
		//Search the leads with the First Name
		dr.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Raja");
		
		//Click Find Leads
		dr.findElementByXPath("//button[text()='Find Leads']").click();
		
		//dr.findElementByXPath("//div[@class='x-grid3-row'][1]/td/a").click();
		
		Thread.sleep(3000);
	
		//Click on the First record
		dr.findElementByLinkText("10491").click();
		
		//Print the Page Title
		System.out.println("Title of the page:   "+""+dr.getTitle());
		
		//Navigate to Edit page
		dr.findElementByLinkText("Edit").click();
		
		//Update the Company Name
		WebElement comUpdate = dr.findElementById("updateLeadForm_companyName");
		comUpdate.clear();
		comUpdate.sendKeys("Tata");
		
		//Trigger the Update button
		dr.findElementByClassName("smallSubmit").click();
		
		//Compare the Company Name
		WebElement vcName = dr.findElementById("viewLead_companyName_sp");
		System.out.println("Updated company Name:  "+ ""+vcName.getText());
		
		if(vcName.getText().startsWith("Tata"))
		{
			System.out.println("Matches with the updated Company Name");
		}
		else
		{
			System.out.println("Not displayed the updated Company Name");
		}
		
		//CLosing the Browser without Logout
		dr.close();
	}

}
