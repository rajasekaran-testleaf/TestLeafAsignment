package Day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandler {

	public static void main(String[] args) throws InterruptedException {
		//Open the Chrome Driver
		ChromeDriver dr = new ChromeDriver();
		
		//Maximize the browser
		dr.manage().window().maximize();
		
		//Implicit wait for the Element wait
		dr.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		//Hitting the LeafTaps site URL
		dr.get("http://leaftaps.com/opentaps/control/main");
		
		/* Enter the User Name, Password
		 * CLick Login Button		
		 */
		dr.findElementById("username").sendKeys("DemoSalesManager");
		dr.findElementById("password").sendKeys("crmsfa");
		dr.findElementByClassName("decorativeSubmit").click();
		
		//Click on CRM/SFA Link
		dr.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		
		//Navigate to the Lead tab
		dr.findElementByXPath("//a[text()='Leads']").click();
		
		//Merge Leads
		dr.findElementByXPath("//a[text()='Merge Leads']").click();
		
		//From Leads
		dr.findElementByXPath("//a[contains(@href,'ComboBox_partyIdFrom')]").click();
	
		/*
		 * Switch the current window to the From Lead Window
		 */
		Set<String> winSize = dr.getWindowHandles();
		List<String> getwinSize = new ArrayList<String>(winSize);
		System.out.println("Total NUmber of Windows opened : "+""+getwinSize.size());
		
		for (String winId : getwinSize) {
			System.out.println("Window ID"+""+winId);
			dr.switchTo().window(winId);
		}
		
		Thread.sleep(3000);
		
		//Search First Name with 'Sangavi'
		dr.findElementByXPath("//label[text()='First name:']/following::input[@name='firstName']").sendKeys("sarath");
		dr.findElementByXPath("//button[text()='Find Leads']").click();
		/*
		 * Retrieve number of records for From Lead
		 * Select first record to merge the lead to the existing one
		 */
		
		Thread.sleep(3000);
		
		List<WebElement> fnameList = dr.findElementsByXPath("//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ')]/div/a");
		System.out.println("Total Number of records for From Lead : "+" "+fnameList.size());
		fnameList.get(0).click();
		System.out.println("FIrst Record clicked for the From Lead");
		
		Thread.sleep(3000);
		
		//Switch back to First Window
		dr.switchTo().window(getwinSize.get(0));
		System.out.println("Moved to First Window after selected the From Lead");
		
		Thread.sleep(3000);
		
		//Retrieve the From Lead Id
		WebElement fromLeadId = dr.findElementByXPath("//table[@name='ComboBox_partyIdFrom']/following::input[@id='partyIdFrom']");
		String fromId = fromLeadId.getAttribute("value");
		System.out.println("From Lead Id :"+""+fromId);
		
		//To Leads
		dr.findElementByXPath("//a[contains(@href,'ComboBox_partyIdTo')]").click();
		
		//Switch to Last Window
		Set<String> winSize1 = dr.getWindowHandles();
		List<String> getwinSize1 = new ArrayList<String>(winSize1);
		System.out.println("Total NUmber of Windows opened : "+""+getwinSize1.size());
		
		for (String winId1 : getwinSize1) {
			System.out.println("Window ID"+""+winId1);
			dr.switchTo().window(winId1);
		}
		Thread.sleep(3000);
				
		// Select first record with First Name 'Gopinath' to merge lead
		 dr.findElementByXPath("//label[text()='First name:']/following::input[@name='firstName']").sendKeys("gopi");
		 dr.findElementByXPath("//button[text()='Find Leads']").click();
		 
		 Thread.sleep(3000);
		 
		/*
		 * Retrieve number of records
		 * Select first record to merge the lead to the existing one
		*/
		List<WebElement> tnameList = dr.findElementsByXPath("//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ')]/div/a");
		System.out.println("Total Number of records for To Lead : "+" "+tnameList.size());
		tnameList.get(0).click();
		System.out.println("First record clicked for the To Lead");
		
		Thread.sleep(3000);
		
		//Switch back to First Window
		dr.switchTo().window(getwinSize.get(0));
		System.out.println("Moved to First Window after selected the To Lead");
		
		//Retrieve the To Lead Id
		WebElement toLeadId = dr.findElementByXPath("//table[@name='ComboBox_partyIdTo']/following::input[@id='partyIdTo']");
		System.out.println("To Lead Id :"+""+toLeadId.getAttribute("value"));
		
		Thread.sleep(3000);
		
		//Click on Merge button
		dr.findElementByXPath("//a[text()='Merge']").click();
		
		//Handling the Alert popup
		Alert canAlert = dr.switchTo().alert();
		canAlert.dismiss();
		
		//Cancel the popup 
		System.out.println("Click on the cancel button");
		
		dr.findElementByXPath("//a[text()='Merge']").click();
		
		//Click Ok button from the popup
		canAlert.accept();
		System.out.println("Click on the Ok button");
		
		//Reassign the role
		dr.findElementByXPath("//img[@src='/images/fieldlookup.gif']").click();
		
		Set<String> reasign = dr.getWindowHandles();
		List<String> lreasign = new ArrayList<String>(reasign);
		lreasign.size();
		
		for (String lreasign1 : lreasign) {
			dr.switchTo().window(lreasign1);
			}
		  List<WebElement> tMember = dr.findElementsByXPath("//tr[@class='crmsfaListTableHeader']/following::a[contains(@href,'javascript:set_value')]");
		  tMember.get(0).click();
		  
		  Thread.sleep(3000);
			
			//Switch back to First Window
			dr.switchTo().window(lreasign.get(0));
			System.out.println("Moved to First Window after selected the To Lead");
			
		  
		//Click Reassign button		
		dr.findElementByXPath("(//input[@class='smallSubmit'])[2]").click();
		
		Thread.sleep(4000);
		
		/*
		 * Find the From Lead Id with From Lead Id
		*/
		dr.findElementByXPath("//a[text()='Find Leads']").click();
		
		Thread.sleep(4000);
		
		dr.findElementByXPath("//input[@name='id']").sendKeys(fromId);
		//dr.findElementByXPath("//label[text()='Lead ID:']/following::input").sendKeys(fromLeadId.getAttribute("value"));
		dr.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(4000);
		
		System.out.println(dr.findElementByXPath("//div[text()='No records to display']").getText());
		
		
		dr.quit();
	}

}
