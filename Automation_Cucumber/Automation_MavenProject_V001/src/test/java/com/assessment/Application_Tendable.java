package com.assessment;


import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.testng.annotations.*;

public class Application_Tendable {

	WebDriver driver;

	@BeforeClass
	public void launch_Navigation() {
		ChromeOptions op=new ChromeOptions();
		op.setBrowserVersion("122");

		driver =new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://www.tendable.com");

	}


	@Test(priority = 1)
	public void confirmAccessibilitity() {
		//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home")));

		String[] allMenus = {"Home", "Our Story", "Our Solution", "Why Tendable"};
		for (String menu : allMenus) {
			WebElement menuElement = driver.findElement(By.xpath("//nav[@id='main-navigation-new']"));	
			Assert.assertTrue(menuElement.isDisplayed(), menu + " menu is not accessible.");
		}

	}


	@Test(priority = 2)
	public void testRequestDemoButtonPresenceAndActivity() {
		String[] allMenus = {"Home","Our Story", "Our Solution", "Why Tendable"};
		for (String menu : allMenus) {
			driver.findElement(By.xpath("//a[@class='button ']")).click();
			WebElement requestDemoButton = driver.findElement(By.xpath("//a[@class='button']"));
			Assert.assertTrue(requestDemoButton.isDisplayed() && requestDemoButton.isEnabled(),
					"Request a Demo button is not present or active on " + menu + " page.");
			driver.navigate().back(); 
		}
	}

	String actualErrorMessage;
	String expectedErrorMessage="Sorry, there was an error submitting the form. Please try again.";

	@Test(priority = 3)
	public void testErrorMessageAppearance() throws InterruptedException {
		driver.findElement(By.linkText("About Us")).click();    
		driver.findElement(By.linkText("Contact Us")).click(); 
		driver.findElement(By.xpath("(//button[text()='Contact'])[1]")).click();

		driver.findElement(By.name("fullName")).sendKeys("Karthik Rajanna");  //xpath- (//label[text()='Full Name']/following::input[@class='freeform-input '])[1]
		driver.findElement(By.id("form-input-organisationName")).sendKeys("XYZ Company");
		driver.findElement(By.id("form-input-cellPhone")).sendKeys("9876543210");
		driver.findElement(By.id("form-input-email")).sendKeys("karthik123@gmail.com");
		Thread.sleep(3000);

		WebElement dropdown=driver.findElement(By.xpath("(//select[@id='form-input-jobRole'])[1]"));
		Select se=new Select(dropdown);
		List<WebElement> options=se.getOptions();
		for(WebElement we:options)
		{
			if(we.getText().equals("Other"))
			{
				we.click();
				break;
			}
		}
		//driver.findElement(By.xpath("(//textarea[@name='message'])[1]")).sendKeys("Ready for On Boarding!");
		driver.findElement(By.xpath("//body[@class='pre-load top-banner-shown']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='consentAgreed'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='button'])[2]")).click();

		Thread.sleep(6000);     //Note: due lack of time i have used Thread.sleep we can use Explicit wait for expected condition where we need.
		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='ff-form-errors']/p")).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Sorry, there was an error submitting the form. Please try again.");
		// If validation fail no error message showing there is bug!
		driver.navigate().back(); 

	}



	// In this scenario there is no bug.
	@Test(priority = 4)
	public void threefailsErrorMessageAppearance() throws InterruptedException {
		driver.findElement(By.linkText("About Us")).click();    
		driver.findElement(By.linkText("Contact Us")).click(); 
		driver.findElement(By.xpath("(//button[text()='Contact'])[1]")).click();

		driver.findElement(By.name("fullName")).sendKeys("karthik rajanna");  // First empty
		driver.findElement(By.id("form-input-organisationName")).sendKeys("XYZ Company");
		driver.findElement(By.id("form-input-cellPhone")).sendKeys("9876543210");
		driver.findElement(By.id("form-input-email")).sendKeys("karthik123@gmail.com");
		Thread.sleep(3000);

		WebElement dropdown=driver.findElement(By.xpath("(//select[@id='form-input-jobRole'])[1]"));
		Select se=new Select(dropdown);
		List<WebElement> options=se.getOptions();
		for(WebElement we:options)
		{
			if(we.getText().equals("Other"))
			{
				we.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//textarea[@name='message'])[1]")).sendKeys("Ready for On Boarding!"); 
		driver.findElement(By.xpath("//body[@class='pre-load top-banner-shown']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='consentAgreed'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='button'])[2]")).click();

	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}
}

