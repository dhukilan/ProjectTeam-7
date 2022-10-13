package org.website;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.Assert;



public class Zappos {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Dhukilan\\eclipse-workspace\\selenium browser\\src\\Driver\\edge\\msedgedriver.exe");
		WebDriver d=new EdgeDriver();
		
		d.get("https://www.zappos.com/");
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement dr = d.findElement(By.xpath("//input[@id='searchAll']"));
		dr.click();
		dr.sendKeys("polo shirt",Keys.ENTER);
		
		WebElement tshirt = d.findElement(By.xpath("//a[contains(text(),'Nautica - Slim Fit Performance Deck Polo.')]"));
		String attribute = tshirt.getText();
		System.out.println(attribute);
		tshirt.click();
		
		//Add to card page
		   //price is display are not
		WebElement pricecheck = d.findElement(By.xpath("//div[@itemprop='offers']"));
		boolean display = pricecheck.isDisplayed();
		System.out.println("Price is display "+display);
		
		//check the product is selected product 
		WebElement tshirtprd = d.findElement(By.xpath("//span[text()='Slim Fit Performance Deck Polo']"));
		String text = tshirtprd.getText();
		boolean equals = text.equals(attribute);
		System.out.println("check the product is selected product "+equals);
		
		//add to card button
		WebElement atc = d.findElement(By.xpath("(//button[@type='submit'])[4]"));
		String text2 = atc.getText();
		System.out.println("get text "+text2);
		
		//add to card button is click
		WebElement addtocardbtn = d.findElement(By.xpath("(//button[@type='submit'])[4]"));
		boolean selected = addtocardbtn.isEnabled();
		System.out.println("add to card button is enable "+selected);
		
		//add to card is same
	    String text3 = addtocardbtn.getText();
	    boolean contains = text3.contains(text2);
	    System.out.println("add to card is same "+contains);
	    
		JavascriptExecutor j=(JavascriptExecutor)d;
		//click the size
		WebElement size = d.findElement(By.xpath("//label[@for='radio-82327']"));
		j.executeScript("arguments[0].click()", size);
		boolean selected2 = size.isEnabled();
		System.out.println("click the size "+selected2);
		
		WebElement adtoclick = d.findElement(By.xpath("(//button[text()='Add to Cart'])[1]"));
		j.executeScript("arguments[0].click()", adtoclick);
		
//		WebElement add = d.findElement(By.xpath("//div[@class='YF-z nl-z rl-z']"));
//		boolean equals = add.equals(addtocardbtn);
//		System.out.println("verify same product are not  "+equals);
		
//		WebElement viewcard = d.findElement(By.xpath("//a[@class='dG-z']"));
//		boolean enabled = viewcard.isEnabled();
//		System.out.println(enabled);
//		
//		j.executeScript("arguments[0].click()", viewcard);
//		
//		WebElement viewpag = d.findElement(By.xpath("//div[@class='Ge-z']"));
//		boolean equals2 = viewpag.equals(viewcard);
//		System.out.println(equals2);
//		
//		WebElement check = d.findElement(By.xpath("//button[text()='Proceed to Checkout']"));
//		boolean enabled2 = check.isEnabled();
//		System.out.println("is enable checkout btn is "+enabled2);
//		
//		check.click();
//		
//		WebElement cancel = d.findElement(By.xpath("//button[@aria-label='Close']"));
//		cancel.click();
//		
//		d.quit();
		

	}

}
