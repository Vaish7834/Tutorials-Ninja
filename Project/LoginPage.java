package TestNGC.First;

import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

	WebDriver driver;
	Properties prop;

	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="My Account")
	WebElement AccountField;

	@FindBy(linkText="Login")
	WebElement LoginField;

	@FindBy(id="input-email")
	WebElement Email;


	@FindBy(id="input-password")
	WebElement pass;
	

	@FindBy(linkText="Logout")
	WebElement Logout;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement Warning;

	public void clickAccountField()
	{
		AccountField.click();
	}
	public void clickLoginField()
	{
		LoginField.click();
	}
	public void enterEmail(String email)
	{
		Email.sendKeys(email);
	}
	public void enterpass(String Password)
	{
		pass.sendKeys(Password,Keys.TAB,Keys.TAB,Keys.ENTER);
	}
	public void clickLogin()
	{
		pass.submit();
	}
	
	public boolean loginSuccessful()
	{
		return Logout.isDisplayed();
	}
	
	public String checkWarning()
	{
		return Warning.getText();
		
	}
	
	

	public String RandomEmail() {
	    
	        String[] emails = {
	            "radhika@gmail.com",
	            "vaishnavi@gmail.com",
	            "priya@gmail.com",
	            "anita@gmail.com",
	            "sneha@gmail.com"
	        };

	        Random random = new Random();
	        int index = random.nextInt(emails.length); // random index
	        String randomEmail = emails[index];

	        return randomEmail;
	    }
	
	public String RandomPass() {
	    
        String[] passkey = {
            "radhika",
            "vaishnavi",
            "priya",
            "anita",
            "1234569"
        };

        Random random = new Random();
        int index = random.nextInt(passkey.length); // random index
        String randomPass = passkey[index];

        return randomPass;
    }
	}




