package Day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver dr = new ChromeDriver();
		
		dr.get("http://leaftaps.com/opentaps/control/main");
		
		// Wait (for the element to appear for the max time: 20)
		dr.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		//Enter the User Name
		WebElement uName = dr.findElementByXPath("//input[@id='username']");
		uName.sendKeys("DemoSalesManager");
		
		//Enter the Password
		WebElement pwd = dr.findElementByXPath("//input[@id='password']");
		pwd.sendKeys("crmsfa");
		
		//Login successful		
		WebElement lButton = dr.findElementByXPath("//input[@class='decorativeSubmit']");
		lButton.click();
	
		//Navigate to CRM/SFA page
		WebElement leadLink = dr.findElementByXPath("//div[@id='label']/a");
		leadLink.click();
		
		Thread.sleep(3000);
		
		//Navigate to Leads page
		WebElement leadTab = dr.findElementByXPath("//a[@href='/crmsfa/control/leadsMain']");
		leadTab.click();
		
		//Find the Lead with First Name
		WebElement findLead = dr.findElementByXPath("//a[@href='/crmsfa/control/findLeads']");
		findLead.click();
		
		//Enter user name
		WebElement fName = dr.findElementByXPath("(//input[@name='firstName'])[3]");
		fName.sendKeys("ramya");
		
		//Search with the First Name
		dr.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(1000);
		
		//Selecting the First row
		WebElement fRow = dr.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a");
		fRow.click();
		
		WebElement ebutton = dr.findElementByXPath("//a[contains(@class,'subMenuButton')][text()='Edit']");
		ebutton.click();
		
		//Update the Company Name
		WebElement cName = dr.findElementByXPath("//input[@id='updateLeadForm_companyName']");
		cName.clear();
		cName.sendKeys("TCS Ltd");
		
		WebElement fname = dr.findElementByXPath("//input[@id='updateLeadForm_firstName']");
		fname.clear();
		fname.sendKeys("ramya".toUpperCase());
		
		//Print the First Name in upper case
		System.out.println("First Name in Upper case :"+ ""+fname.getAttribute("value"));
		
		//Click on calendar icon and select the date
		WebElement calen = dr.findElementByXPath("//img[@id='updateLeadForm_birthDate-button']");
		calen.click();
		WebElement calDate = dr.findElementByXPath("(//td[text()='30'])[2]");
		calDate.click();
		
		Thread.sleep(2000);
		
		//Print the Birth date
		System.out.println("Birthdate : "+""+dr.findElementByXPath("//input[@id='updateLeadForm_birthDate']").getAttribute("value"));
		
		//Click on Update button
		dr.findElementByXPath("//input[@class='smallSubmit'][@value='Update']").click();
		
		
		
		System.out.println("update done successfully");
		
		}

}
