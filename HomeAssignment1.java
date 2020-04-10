package Day9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomeAssignment1 {

	public static void main(String[] args) throws InterruptedException {
	
		//Open the Chrome Driver
		ChromeDriver dr = new ChromeDriver();
		
		// Wait (for the element to appear for the max time: 20)
		dr.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		//Print the Browser name
		dr.getCapabilities().getBrowserName();
		
		//Hitting the TestLeaf URL
		dr.get("http://www.leafground.com");
		
		//Navigate to the droppable page
		WebElement selectableLink = dr.findElementByXPath("//h5[text()='Droppable']");
		selectableLink.click();
		
		//Collect the element information
		WebElement drag = dr.findElementById("draggable");
		WebElement drop = dr.findElementById("droppable");
		
		//Actions - drag the element and drop into the another element
		Actions builder = new Actions(dr);
		builder.dragAndDrop(drag,drop).perform();
		
		//Close the browser
		dr.close();
		
	}
}
