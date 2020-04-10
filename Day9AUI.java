package Day9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Day9AUI {

	public static void main(String[] args) throws InterruptedException {
	
		//Open the Chrome Driver
		ChromeDriver dr = new ChromeDriver();
		
		// Wait (for the element to appear for the max time: 20)
		dr.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		//Print the Browser name
		dr.getCapabilities().getBrowserName();
		
		//Hitting the TestLeaf URL
		dr.get("http://www.leafground.com/home.html");
		
		
		WebElement selectableLink = dr.findElementByLinkText("Selectable");
		selectableLink.click();
				
		WebElement item4 = dr.findElementByXPath("//ol[@id='selectable']/li[4]");
		WebElement item5 = dr.findElementByXPath("//ol[@id='selectable']/li[5]");
		WebElement item6 = dr.findElementByXPath("//ol[@id='selectable']/li[6]");
		WebElement item7 = dr.findElementByXPath("//ol[@id='selectable']/li[7]");
		
		Actions builder = new Actions(dr);
		builder.keyDown(Keys.COMMAND).click(item4).click(item5).click(item6).click(item7).perform();
		
		dr.close();
		
	}
}
