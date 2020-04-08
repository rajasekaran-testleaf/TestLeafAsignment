package Day7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MulitpleElementsClassAssignment {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver dr = new ChromeDriver();
		
		dr.get("http://www.leafground.com/pages/Link.html");
		
		// Wait (for the element to appear for the max time: 20)
		dr.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		//Find the Element of Links
		List<WebElement> linkCount = dr.findElementsByXPath("//a[@href]");
		
		//Return the link count
		int size = linkCount.size();
		System.out.println("No of link present in the page : "+""+size);
		
		//Return the first link Name
			linkCount.get(0).click();
		
		Thread.sleep(1000);
		
		System.out.println("First link name :" +""+dr.getTitle());
		
		//Back to Home page
		dr.navigate().back();
		
		//CLick on the Last link of Home Page
		List<WebElement> linkHome = dr.findElementsByXPath("(//a[text()='Go to Home Page'])");
		System.out.println("No of link: "+""+linkHome.size());
		
		linkHome.get(linkHome.size()-1).click();
		
		//Navigate back to Home Page
		dr.navigate().back();
		
	}

}
