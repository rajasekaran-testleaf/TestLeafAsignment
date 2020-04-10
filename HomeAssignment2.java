package Day9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HomeAssignment2 {

	public static void main(String[] args) throws InterruptedException {
	
		//Open the Chrome Driver
				ChromeDriver dr = new ChromeDriver();
				
				// Wait (for the element to appear for the max time: 20)
				dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Print the Browser name
				dr.getCapabilities().getBrowserName();
				
				//Hitting the TestLeaf URL
				dr.get("https://www.flipkart.com/");
				
				//Close the Login popup				
				dr.findElementByXPath("//button[text()='✕']").click();
				
				Thread.sleep(3000);
				
				//Collect all the Element information
				WebElement item4 = dr.findElementByXPath("//span[text()='Electronics']");
				WebElement item5 = dr.findElementByXPath("//a[text()='Mi']");
				
				//Actions
				Actions builder = new Actions(dr);
				builder.moveToElement(item4).perform();

				Thread.sleep(3000);
				
				//Click on the Mi option
				item5.click();
			
				Thread.sleep(3000);
				
				//Print the Page Title
				System.out.println(dr.getTitle());
				
			dr.close();
	}
}
