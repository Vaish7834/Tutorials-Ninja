package AutomationProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckingAllPlaceHolderAreCorrectOrNot {

	WebDriver driver;
	@Test
	public void verifyPlaceHolder()
	{
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		String firstNamePlaceholder = "First Name";
		//			Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("PlaceHolder"),firstNamePlaceholder);
		try {
			Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("PlaceHolder"),firstNamePlaceholder);
			System.out.println("PlaceHolder Matching 1");
		}

		catch (AssertionError e) {
			System.out.println("PlaceHolder not Matching 1");
			throw e; // re-throw to fail the test
		}
		String LastNamePlaceholder = "Last Name";
		//			Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("PlaceHolder"),LastNamePlaceholder );
		try {
			Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("PlaceHolder"),LastNamePlaceholder );
			System.out.println("PlaceHolder Matching 2");
		}

		catch (AssertionError e) {
			System.out.println("PlaceHolder not Matching 2");
			throw e; // re-throw to fail the test
		}
		String email = "E-Mail";
//		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("PlaceHolder"),email);

		try {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("PlaceHolder"),email);
			System.out.println("PlaceHolder Matching 3");
		}

		catch (AssertionError e) {
			System.out.println("PlaceHolder not Matching 3");
			throw e; // re-throw to fail the test
		}

		String tel = "Telephone";
//		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("PlaceHolder"),tel);

		try {
			Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("PlaceHolder"),tel);
			System.out.println("PlaceHolder Matching 4");
		}

		catch (AssertionError e) {
			System.out.println("PlaceHolder not Matching 4");
			throw e; // re-throw to fail the test
		}
		String password = "Password";
//		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("PlaceHolder"),password);

		try {
			Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("PlaceHolder"),password);
			System.out.println("PlaceHolder Matching 5");
		}

		catch (AssertionError e) {
			System.out.println("PlaceHolder not Matching 5");
			throw e; // re-throw to fail the test
		}

		String passwordconfirm = "Password Confirm";
//		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("PlaceHolder"),passwordconfirm);
		try {
			Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("PlaceHolder"),passwordconfirm);
			System.out.println("PlaceHolder Matching 6");
		}

		catch (AssertionError e) {
			System.out.println("PlaceHolder not Matching 6");
			throw e; // re-throw to fail the test
		}
	}
}
