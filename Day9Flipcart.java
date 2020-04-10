package Day9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Day9Flipcart {

	public static void main(String[] args) throws InterruptedException {
	
		//Open the Chrome Driver
		ChromeDriver dr = new ChromeDriver();
		
		// Wait (for the element to appear for the max time: 20)
		dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Print the Browser name
		dr.getCapabilities().getBrowserName();
		
		//Hitting the TestLeaf URL
		dr.get("https://www.flipkart.com/");
		
		dr.findElementByXPath("//button[text()='✕']").click();
		
		Thread.sleep(3000);
		
		WebElement item4 = dr.findElementByXPath("//span[text()='TVs & Appliances']");
		WebElement item5 = dr.findElementByXPath("//a[text()='LG']");
				
		Actions builder = new Actions(dr);
		builder.moveToElement(item4).perform();
		
		Thread.sleep(3000);
		
		item5.click();
		
		WebElement firstTV = dr.findElementByXPath("//div[text()='LG All-in-One 80cm (32 inch) HD Ready LED Smart TV']");
		System.out.println(firstTV.getText());
		
		dr.close();
		
	}
}
