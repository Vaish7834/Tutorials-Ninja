package AutomationProjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingAsteriskSymbolPresentOrNot {

	@Test
	public void VerifyMethod()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();

		// Find all labels
		List<WebElement> labels = driver.findElements(By.tagName("label"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Check each label
		for (WebElement label : labels) {
			// Get the * symbol (if any) before the label
			String content = (String) js.executeScript(
					"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", label
					);
			String color = (String) js.executeScript(
					"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", label
					);
			if (content != null) 
			{
				content = content.replace("\"", "").trim();
				System.out.println("Content over "+content);
			}


			// Print if it's a mandatory field
			if ("*".equals(content) && color.contains("rgb(255, 0, 0)")) {
				System.out.println("Mandatory field: " + label.getText());
			}
		}

		// Close browser
//		driver.quit();
	}
}


