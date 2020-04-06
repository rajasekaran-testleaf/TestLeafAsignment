package firstWeekend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondAssignment {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver dr = new ChromeDriver();
		
		dr.manage().window().maximize();
		
		//Launch the TestLeaf website
		dr.get("http://leaftaps.com/opentaps/control/main");
		
		dr.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
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
		
		//Navigate to Phone tab
		dr.findElementByXPath("//span[text()='Phone']").click();
		
		//Search the leads with the Phone Number
		dr.findElementByName("phoneNumber").sendKeys("1234567890");

		//Click Find Leads
		dr.findElementByXPath("//button[text()='Find Leads']").click();
	
		//Click on the First record
		WebElement leadId = dr.findElementByLinkText("10725");
		leadId.click();
		
		//Print the Page Title
		System.out.println("Title of the page:   "+""+dr.getTitle());
		
		//Delete the existing lead
		dr.findElementByLinkText("Delete").click();
		
		//Navigate to Find Leads page
		dr.findElementByXPath("//a[text()='Find Leads']").click();
		
		//Click on the First record
		dr.findElementByName("id").sendKeys("10725");
				
		//Click Find Leads
		dr.findElementByXPath("//button[text()='Find Leads']").click();
				
		System.out.println("Result : "+""+dr.findElementByXPath("//div[text()='No records to display']").getText());	
		
		//Close the Browser without Logout
		dr.close();
	}

}
