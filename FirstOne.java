package Day1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstOne {

	public static void main(String[] args) throws InterruptedException {

		// add system property -> webdriver.chrome.driver
				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
						
						
					//Open the Chrome Driver
					ChromeDriver dr = new ChromeDriver();
					
					//Implicit wait for the Element wait
					dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					//Maximize the browser
					dr.manage().window().maximize();
					
					//Launch the ServiceNow application URL: https://dev92474.service-now.com/	
					//Hitting the LeafTaps site URL
					dr.get("https://dev92474.service-now.com/");
					
					Thread.sleep(3000);
					
					//Switch to the Frame
					dr.switchTo().frame("gsft_main");
					
				
					//Login with valid credentials username as admin and password as India@123	
					/* Enter the User Name, Password
					 * CLick Login Button		
					 */
					dr.findElementByXPath("//label[text()='User name']/following::input[@id='user_name']").sendKeys("admin");
					dr.findElementByXPath("//label[text()='Password']/following::input[@id='user_password']").sendKeys("India@123");
					dr.findElementByXPath("//button[text()='Login']").click();
					
					Thread.sleep(3000);
					
					//Enter Change in filter navigator and press enter	
					dr.findElementByXPath("//input[@id='filter']").sendKeys("change", Keys.ENTER);
					
					Thread.sleep(3000);
					
					dr.findElementByXPath("(//div[text()='Create New'])[3]").click();
					
					Thread.sleep(3000);
					//Switch to the Frame
					dr.switchTo().frame("gsft_main");
					
					Thread.sleep(3000);
					dr.findElement(By.linkText("Normal: Changes without predefined plans require approval and/or CAB authorization.")).click();
					
					Thread.sleep(3000);
					//Capture the New Change Request Number
					WebElement cNumber = dr.findElementById("change_request.number");
					String changeNumber = cNumber.getAttribute("value");
					System.out.println("CHange request Number"+""+changeNumber);
					
					//Enter the Short Description
					WebElement sDescription = dr.findElementByXPath("//input[@id='change_request.short_description']");
					sDescription.sendKeys("Created New Change Request");
					System.out.println("New :"+""+sDescription);
					
					//Click on SUbmit button					
					dr.findElementByXPath("(//button[@type='submit'])[2]").click();
					
					Thread.sleep(3000);
					//CLick All link
					dr.findElementByXPath("(//div[text()='All'])[4]").click();
					
					Thread.sleep(3000);
					//Enter the Newly created Change request number
					WebElement sNumber = dr.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input");
					sNumber.sendKeys(changeNumber, Keys.ENTER);
					
					Thread.sleep(3000);
					// Click the link
					dr.findElementByClassName("linked formlink").click();
					
					Thread.sleep(3000);
					// Validate the Change Request number
					String act = dr.findElementById("change_request.number").getAttribute("value");
					if(act.equals(cNumber)) {
					System.out.println("Change Request number is same");
					}
					
					// Closing the Browser
					dr.close();

	}

}
