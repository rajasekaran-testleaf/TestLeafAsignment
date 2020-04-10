package Day9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomeAssignment3 {

	public static void main(String[] args) throws InterruptedException {
	
		//Open the Chrome Driver
		ChromeDriver dr = new ChromeDriver();
		
		// Wait (for the element to appear for the max time: 20)
		dr.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
	
		//Hitting the TestLeaf URL
		dr.get("http://www.leafground.com/home.html");
		
		//Navigate to Sortable page
		WebElement selectableLink = dr.findElementByXPath("//h5[text()='Sortable']");
		selectableLink.click();
		
		//Find the Item 1 Element information
		WebElement item1 = dr.findElementByXPath("//li[text()='Item 1']");
		
		Actions builder = new Actions(dr);
		
		//Move item1 to below item3
		builder.dragAndDropBy(item1, 0,90).build().perform();
	}


}
