package Day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClassAssignment {

	public static void main(String[] args) throws InterruptedException {

			//Open the Chrome Driver
			ChromeDriver dr = new ChromeDriver();
			
			//Maximize the browser
			dr.manage().window().maximize();
			
			//Implicit wait for the Element wait
			dr.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
			
			//Step 1 Launch the ServiceNow application URL: https://dev92474.service-now.com/	
			//Hitting the LeafTaps site URL
			dr.get("https://dev92474.service-now.com/");
			
			//Switch to the Frame
			dr.switchTo().frame(0);
			
			//Step  2 Login with valid credentials username as admin and password as India@123	
			/* Enter the User Name, Password
			 * CLick Login Button		
			 */
			dr.findElementByXPath("//label[text()='User name']/following::input[@id='user_name']").sendKeys("admin");
			dr.findElementByXPath("//label[text()='Password']/following::input[@id='user_password']").sendKeys("India@123");
			dr.findElementByXPath("//button[text()='Login']").click();
			
			//Step 3 Enter Incident in filter navigator and press enter	
			//Filter the Incident category
			//dr.findElementByXPath("//input[@name='filter']").clear();
			dr.findElementByXPath("//input[@name='filter']").sendKeys("Incident", Keys.ENTER);
			
			Thread.sleep(3000);
			 
			//Step 4 Click on Create new option Under Incident
			WebElement cNew = dr.findElementByXPath("//a[@class='sn-widget-list-item sn-widget-list-item_hidden-action module-node']/div/div[text()='Create New']");
			cNew.click();
			
			Thread.sleep(3000);
			
			//Switch to the Frame
			dr.switchTo().frame(0);
			
			//Step  5 Get the text of Number Field and Store it in a String
			String iNumber = dr.findElementById("incident.number").getAttribute("value");
			System.out.println("New Incident Number : "+""+iNumber);
			
			/*
			//Step 6 - First Record
			dr.findElementByXPath("//button[@id='lookup.incident.caller_id']").click();
			
			//window Handler
			Set<String> winSize = dr.getWindowHandles();
			List<String> getwinSize = new ArrayList<String>(winSize);
			System.out.println("Windows Id: "+""+getwinSize);
			String sWin = getwinSize.get(1);	
			dr.switchTo().window(sWin);
			
			Thread.sleep(4000);
						
			dr.findElementByClassName("glide_ref_item_link").click();
			
			Thread.sleep(4000);
			
			//Switch back to First Window
			String fWin = getwinSize.get(0);
			dr.switchTo().window(fWin);
			
			System.out.println("Incident Id NUmber : "+dr.findElementById("sys_display.incident.caller_id").getAttribute("value"));
			
			Thread.sleep(4000);
			
			//Step 7 - Category
			dr.findElementById("lookup.incident.caller_id").sendKeys(Keys.TAB);
			
			*/
			
			WebElement cate = dr.findElementByName("incident.category");
			Select cate1 = new Select(cate);
			cate1.selectByValue("Software");
			
			//Step 8 - Sub-category
			WebElement subcate = dr.findElementByName("//select[@id='incident.subcategory']");
			Select subcate1 = new Select(subcate);
			subcate1.selectByValue("email");
			
			
			//Step 9 - Contact
			WebElement cont = dr.findElementByName("incident.contact_type");
			Select cont1 = new Select(cont);
			cont1.selectByVisibleText("Walk-in");
			
			//Step 10 - Status
			WebElement status = dr.findElementByName("incident.state");
			Select status1 = new Select(status);
			status1.selectByVisibleText("In Progress");
			
			//Step 11 - Urgency
			WebElement urgeny = dr.findElementByName("incident.urgency");
			Select urgeny1 = new Select(urgeny);
			urgeny1.deselectByVisibleText("1 - High");
			
			/*
			 * //12. Click on the Search Button Available in the Assignment Group & Choose Last Residing Value Opened in new Window
	
			
			dr.findElementById("lookup.incident.assignment_group").click();
			//window Handler
			Set<String> winSize1 = dr.getWindowHandles();
			//List<String> getwinSize1 = new ArrayList<String>(winSize1);
						
			for (String winId1 : winSize1) {
				dr.switchTo().window(winId1);
			}
			
			//Select the Last record in the first page
			dr.findElementByXPath("(//a[@class='glide_ref_item_link'])[20]").click();
			
			
			//Switch back to First Window
			String firstwin2 = dr.getWindowHandle();
			dr.switchTo().window(firstwin2);
			
			*/
			
			//13. Enter Short Description as "Creating Incident For the Purpose of Management"
			dr.findElementById("incident.short_description").sendKeys("Creating the new Incident");
			
			//14. Click on the Submit Button
			dr.findElementByXPath("//button[text()='Submit']").click();
			
			//15. Enter The Incident Number Newly created in Search Field and Press Enter
			dr.findElementByXPath("//label[text()='Search']/following::input").sendKeys(iNumber, Keys.ENTER);
			
			Thread.sleep(8000);
			
			//16. Click on the newly Created Incident Displayed
			dr.findElementByXPath("//a[@class='linked formlink']").click();
			
			Thread.sleep(8000);
			
			//17. Verify the Incident Number
			String newId = dr.findElementById("incident.number").getAttribute("id");
			
			if (iNumber.equals(newId))
			{
				System.out.println("New Incident Id Matched");
			}
									
			//18. Update Impact as High
			
			WebElement updateimpact = dr.findElementByName("incident.impact");
			Select updateimpact1 = new Select(updateimpact);
			updateimpact1.selectByVisibleText("1 - High");
			
			//19. Update Description as "Successfully Created an incident"
			WebElement des = dr.findElementById("incident.short_description");
			des.clear();
			
			Thread.sleep(8000);
			des.sendKeys("Sucessfully Created an Incident");
			
			//20. Enter Work Notes as "Done Right"
			dr.findElementByXPath("//textarea[@id='activity-stream-textarea']").sendKeys("Done Right");
			
			//21. Click on the Update button.
			dr.findElementByXPath("//button[text()='Update']").click();
			
			Thread.sleep(3000);
			System.out.println("Incident Updated succesfully");
			
			//22. Logout and Close
			dr.findElementByXPath("//span[@class='caret']").click();
			dr.findElementByXPath("//a[text()='Logout']").click();
			
			dr.close();
			
	
	
	}
}
