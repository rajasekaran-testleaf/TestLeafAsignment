package Day7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeAssignment34 {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver dr = new ChromeDriver();
		
		dr.get("http://www.leafground.com/pages/Link.html");
		
		// Wait (for the element to appear for the max time: 20)
		dr.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		//Find the Element of Links
		List<WebElement> linkCount = dr.findElementsByXPath("//a[@href]");
		linkCount.get(0).click();
		
		//Navigate to Radio button page
		List<WebElement> radioCount = dr.findElementsByXPath("//h5[text()='Radio Button']/following-sibling::img");
		radioCount.get(0).click();
		
		List<WebElement> radioLink = dr.findElementsByXPath("//input[@type='radio']");
		System.out.println("radio count : "+""+radioLink.size());
		
		dr.navigate().back();
		
		//Navigate to Checkbox page
		List<WebElement> checkboxCount = dr.findElementsByXPath("//h5[text()='Checkbox']/following-sibling::img");
		checkboxCount.get(0).click();
		
		List<WebElement> checklist = dr.findElementsByXPath("//label[text()='Select all below checkboxes ']/following::input[@type='checkbox']");
		System.out.println("Check Box count : "+""+checklist.size());
		
		for (int i = 0; i < checklist.size() ; i++) 
		{
			 WebElement cName = checklist.get(i);
			 cName.click();
			 
			//String oName = dr.findElementsByXPath("//label[text()='Select all below checkboxes ']/following-sibling::div");		 
			 
			List<WebElement> oName = dr.findElementsByXPath("//label[text()='Select all below checkboxes ']/following-sibling::div");	
			 
			System.out.println("Label Name "+i+":"+oName.get(i).getText());
			 
		}
		
		System.out.println("All checkbos is selected");
		dr.close();
	}
}
