package AutomationProjects;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingTheLeadingAndTrailingSpacesAreRemovedOrNot {


	@Test
	public void VerifyMethods() throws InterruptedException
	{

		Date date = new Date();
		String dates = date.toString().replaceAll(" ","").replace(":", "");
		String dates2=dates+"@gmail.com";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		driver.findElement(By.linkText("My Account")).click();
		Actions act = new Actions(driver);
		WebElement element = driver.findElement
				(By.xpath
						("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));
		act.moveToElement(element).click().perform();
		String fName="    vaish    ";
		String lName="    Yadav   ";

		WebElement FirstName = driver.findElement(By.id("input-firstname"));
		WebElement LastName = driver.findElement(By.id("input-lastname"));
		WebElement checkbox= driver.findElement(By.name("agree"));
		act.moveToElement(FirstName).click().sendKeys(fName,Keys.TAB)
		.sendKeys(lName,Keys.TAB)
		.sendKeys(dates2,Keys.TAB)
		.sendKeys("1234567890",Keys.TAB)
		.sendKeys("Yadav@123",Keys.TAB)
		.sendKeys("Yadav@123",Keys.TAB)
		.build().perform();
		WebElement radioButton = driver.findElement(By.xpath("//label[contains(.,'No')]"));
		act.moveToElement(radioButton)
		.click()
		.sendKeys(Keys.TAB,Keys.TAB).click().build().perform();
		WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkBox.click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Edit your account information")).click();
		try {
		Assert.assertEquals((driver.findElement(By.id("input-firstname"))).getAttribute("value")
				,fName.trim());
		Assert.assertEquals((driver.findElement(By.id("input-lastname"))).getAttribute("value")
				,lName.trim());
		}
		catch(AssertionError e)
		{
			System.out.println("Error occured due to firstname and lastname taking spaces not trimming it");
			throw e;
		}
//		try {
//		Assert.assertEquals((driver.findElement(By.id("input-lastname"))).getAttribute("value")
//				,lName.trim());
//		}
//		catch(AssertionError e)
//		{
//			System.out.println("Failed testcase");
//			throw e;
//		}

	}
}
