package TutorialsNinja;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestNGC.First.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;


public class Login {
	LoginPage loginpage;
	WebDriver driver;
	Properties prop;
	ConfigReader config;

	@BeforeMethod
	public void setUp()
	{
		config = new ConfigReader();
		prop = config.ConfigReader();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		loginpage.clickAccountField();
		loginpage.clickLoginField();

	}
	@Test(priority=1)
	public void verifyLoginWithValidCredentials()
	{
		
		loginpage.enterEmail(prop.getProperty("email"));
		loginpage.enterpass(prop.getProperty("pass"));
		if(loginpage.loginSuccessful())
		{
			System.out.println("login successful");
		}
		else
		{
			System.out.println("Not successful");
		}


	}
	@Test(priority=2)
	public void verifyLoginwithInvalidCredentials()
	{
		String expected ="Warning: No match for E-Mail Address and/or Password.";
		loginpage.enterEmail(loginpage.RandomEmail());
		loginpage.enterpass(prop.getProperty("Invalidpass"));
		loginpage.clickLogin();
		Assert.assertEquals(expected, loginpage.checkWarning());
		if(expected.contentEquals(loginpage.checkWarning()))
		{
			System.out.println("Test passed. warning message displayed when invalid credentials are entered.");
		}
		else
		{
			System.out.println("Test failed. No warning message displayed when invalid credentials are entered."
					+ " System should notify the user.");
		}
//		System.out.println(expected);
//		System.out.println(loginpage.checkWarning());
	}
	
	@Test(priority=3)
	public void verifyLoginwithInvalidEmailandValidPassword()
	{
		String expected ="Warning: No match for E-Mail Address and/or Password.";
		loginpage.enterEmail(loginpage.RandomEmail());
		loginpage.enterpass(prop.getProperty("pass"));
		loginpage.clickLogin();
		Assert.assertEquals(expected, loginpage.checkWarning());
		if(expected.contentEquals(loginpage.checkWarning()))
		{
			System.out.println("Test passed. warning message displayed when invalid credentials are entered.");
		}
		else
		{
			System.out.println("Test failed. No warning message displayed when invalid credentials are entered."
					+ " System should notify the user.");
		}
//		System.out.println(expected);
//		System.out.println(loginpage.checkWarning());
	}
	
	@Test(priority=4)
	public void verifyLoginwithvalidEmailandInValidPassword()
	{
		String expected ="Warning: No match for E-Mail Address and/or Password.";
		loginpage.enterEmail(prop.getProperty("email"));
		loginpage.enterpass(loginpage.RandomPass());
		loginpage.clickLogin();
		Assert.assertEquals(expected, loginpage.checkWarning());
		if(expected.contentEquals(loginpage.checkWarning()))
		{
			System.out.println("Test passed. warning message displayed when invalid credentials are entered.");
		}
		else
		{
			System.out.println("Test failed. No warning message displayed when invalid credentials are entered."
					+ " System should notify the user.");
		}
//		System.out.println(expected);
//		System.out.println(loginpage.checkWarning());
	}
}
