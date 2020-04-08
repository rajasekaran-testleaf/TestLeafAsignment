package Day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeletetLead {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver dr = new ChromeDriver();
		
		// Wait (for the element to appear for the max time: 20)
		dr.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		dr.get("http://leaftaps.com/opentaps/control/main");
				
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
		fName.sendKeys("revathi");
		
		//Search with the First Name
		dr.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		
		//Selecting the First row
		WebElement fRow = dr.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a");
		System.out.println("Selected Row Lead Id :"+""+fRow.getText());
		Thread.sleep(1000);
		fRow.click();
		
		WebElement ebutton = dr.findElementByXPath("//a[@class='subMenuButtonDangerous']");
		ebutton.click();
		
		Thread.sleep(2000);
		
		//Find the Lead with First Name
		WebElement findLead1 = dr.findElementByXPath("//a[@href='/crmsfa/control/findLeads']");
		findLead1.click();
		
		Thread.sleep(2000);
		
		//Enter user name
		WebElement fName1 = dr.findElementByXPath("(//input[@name='firstName'])[3]");
		fName1.sendKeys("revathi");
				
		//Search with the First Name
		dr.findElementByXPath("//button[text()='Find Leads']").click();
				
		Thread.sleep(1000);
				
		//Selecting the First row
		WebElement fRow1 = dr.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a");
		fRow1.getAttribute("value");
		
		System.out.println("Selected Row Lead Id :"+""+fRow1.getText());
		
		if(fRow1!=(fRow))
		
		System.out.println("Deleted Sucessfully");
		
		else
			
		System.out.println("Delete is not working");
		}

}
