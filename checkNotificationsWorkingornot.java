package AutomationProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class checkNotificationsWorkingornot {
	@Test
	public void verifyWarningswithoutfillingForm() throws InterruptedException{
		// TODO Auto-generated method stub
		////li[@class='dropdown open']//li[1]

		//WebDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		WebElement register = driver.findElement(By.linkText("Register"));


		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(register).click().perform();

		//to continue need to scroll page 

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		WebElement Continue = driver.findElement(By.cssSelector("input[value='Continue']"));
		act.moveToElement(Continue).click().perform();

		String expected="First Name must be between 1 and 32 characters!";
		String expected2="Last Name must be between 1 and 32 characters!";
		String expected3="E-Mail Address does not appear to be valid!";
		String expected4="Telephone must be between 3 and 32 characters!";
		String expected5="Password must be between 4 and 20 characters!";
		//String expected6="Warning: You must agree to the Privacy Policy!";

		//	String actual = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		try {
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(),expected);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(),expected2);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText(),expected3);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(),expected4);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText(),expected5);


			System.out.println("Warnings verified all are working fine"); // console message
		} catch (AssertionError e) {
			System.out.println( "Getting error");
			throw e; // re-throw to fail the test
		}




	}


}
