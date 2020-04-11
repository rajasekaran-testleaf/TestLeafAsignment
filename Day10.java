package Day10;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class Day10 {

	public static void main(String[] args) throws InterruptedException {
	
		//Open the Chrome Driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver dr = new ChromeDriver(options);
		
		// Wait (for the element to appear for the max time: 20)
		dr.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		//Maximize the browser
		dr.manage().window().maximize();
		
		//Step 1 - Hitting the TestLeaf URL
		dr.get("https://www.myntra.com/");	
		
		//Step 2 - Mouse hover on Women menu
		WebElement mWomen = dr.findElementByXPath("//a[text()='Women']");
		
		Actions builder = new Actions(dr);
		builder.moveToElement(mWomen).perform();

		//Step 3 - Click Jacket & coats
		WebElement jacketCoats = dr.findElementByXPath("//a[text()='Jackets & Coats']");
		jacketCoats.click();
		
		Thread.sleep(3000);
		
		//Step 4 -  Find the total count of item (top)
		WebElement totalCount = dr.findElementByXPath("//span[@class='title-count']");
		String cCount = totalCount.getText();
		String tCount = cCount.replaceAll("\\D", "");
		System.out.println("Top Count : "+""+tCount);
		int top = Integer.parseInt(tCount);
		
		WebElement cJacket = dr.findElementByXPath("//input[@value='Jackets']/following-sibling::span");
		String text = cJacket.getText();
		String jacketNo = text.replaceAll("\\D", "");
		System.out.println("Jacket Count :"+""+jacketNo);
		int b = Integer.parseInt(jacketNo);
		
		WebElement cCoat = dr.findElementByXPath("//input[@value='Coats']/following-sibling::span");
		String text1 = cCoat.getText();
		String coatNo = text1	.replaceAll("\\D", "");
		System.out.println("Jacket Count :"+""+coatNo);
		int c = Integer.parseInt(coatNo);
		
		//Step 5 - Validate the sum of categories count matches
		
		int categories = b+c;
		
		if (categories==top)
		{
			System.out.println("Top count and SUm of Categories are Equal");
		}
		
		else
		{
			System.out.println("Top count and SUm of Categories are Not Equal");
		}
		
		Thread.sleep(3000);
		
		//Step 6 - check the coat
		WebElement coat = dr.findElementByXPath("//input[@value='Coats']/following::div");
		coat.click();
		
		//Return the Coats count
		String str = dr.findElementByXPath("//input[@value='Coats']/following::span").getText();
		String actual = str.replaceAll("\\D","");
		int coatCountt = Integer.parseInt(actual);
		System.out.println("Coat count : "+""+coatCountt);
		
		Thread.sleep(3000);
		
		//step 7 - Click + More option under BRAND 
		dr.findElementByXPath("//div[@class='brand-more']").click();
		
		Thread.sleep(3000);
		
		//Step 8 - Type MANGO and click checkbox
		WebElement sBrand = dr.findElementByXPath("//input[@placeholder='Search brand']");
		sBrand.sendKeys("Mango");
		
		
		dr.findElementByXPath("(//label[text()='MANGO']/div)[2]").click();
		//dr.findElementByXPath("//input[@value='MANGO']/following::div").click();
		
		Thread.sleep(3000);
			
		//Step 9 - Close the pop-up 
		dr.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		
		Thread.sleep(3000);
		
		//Step 10 - Confirm all the Coats are of brand MANGO
		List<WebElement> bName = dr.findElementsByClassName("product-brand");
		int bSize = bName.size();
		
		for (int i = 0; i < bSize; i++) 
		{
			if (((bName.get(i)).getText()).equals("MANGO"))
			{
			String a1 = "Matched";
			System.out.println("Result : "+i+" - "+a1);
			}
			else
			{
			String b1 = "Not Matched";
			System.out.println("Result : "+i+" - "+b1);
			}
		
		}
		
		Thread.sleep(3000);
		
		//Step 11 - Sort by Better Discount
		
		dr.findElementByClassName("sort-sortBy").click();
		dr.findElementByXPath("//label[text()='Better Discount']").click();
		
		Thread.sleep(3000);
		
		//Step 12 - Find the price of first displayed item
		List<WebElement> firstPrice = dr.findElementsByClassName("product-discountedPrice");
		System.out.println("First Price : "+""+firstPrice.get(0).getText());
		
		//Step 13 - Mouse over on size of the first item
		List<WebElement> pSize = dr.findElementsByXPath("//div/h3[text()='MANGO']");
		
		Actions builder2 = new Actions(dr);
		builder2.moveToElement(pSize.get(0)).perform();
		
		List<WebElement> sizeProduct = dr.findElementsByXPath("//h4[@class='product-sizes']");
		int productSize = sizeProduct.size();
		System.out.println("Count of Wish Size :"+""+productSize);
		
		//Return Size of the product
		System.out.println("Size of the Product : "+""+sizeProduct.get(0).getText());
		
		//Step 14 - Click on WishList Now
		List<WebElement> wishList = dr.findElementsByXPath("//div/h3[text()='MANGO']");
		
		Actions builder3 = new Actions(dr);
		builder3.moveToElement(wishList.get(0)).perform();
		
		Thread.sleep(3000);
		
		List<WebElement> wClick = dr.findElementsByXPath("(//span[text()='wishlist now'])[1]");
		wClick.get(0).click();
		
		Thread.sleep(3000);
		
		//Step 15 - Close
		dr.close();
		
		}

	
}
