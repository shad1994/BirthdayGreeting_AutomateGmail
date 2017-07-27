package FirstProject.BirthdayGreeting;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposeMail {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String args[]) throws IOException, InterruptedException {
		
		BrowserLaunch.launchBrowser();

		Locators locator = new Locators();
		driver=BrowserLaunch.driver;
		wait=BrowserLaunch.wait;
		driver.get("https://accounts.google.com/signin");

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator.findLocator("email")));
		
		
		driver.findElement(locator.findLocator("email")).sendKeys("shad.sayeed2");
   
		driver.manage().window().maximize();
		// email;
		System.out.println("email id entered..");

		 wait.until(ExpectedConditions.visibilityOfElementLocated(locator.findLocator("nextbutton")));
		 
		driver.findElement(locator.findLocator("nextbutton")).click();


		System.out.println("enter the password..");

		/// Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator.findLocator("password")));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headingText")));

		driver.findElement(locator.findLocator("password")).sendKeys("shad1994");
		System.out.println("password entered..");

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator.findLocator("nextbutton")));

		WebElement button2 = driver.findElement(locator.findLocator("nextbutton"));
		button2.click();
		System.out.println("Welcome ...");

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator.findLocator("inbox")));

		driver.findElement(locator.findLocator("inbox")).click();

		// System.out.println("Time to open your inbox ...");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator.findLocator("composebutton")));
		WebElement compose = driver.findElement(locator.findLocator("composebutton"));
		compose.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator.findLocator("toContact")));
 
		
		WebElement to = driver.findElement(locator.findLocator("toContact"));
		Actions actions = new Actions(driver);
		actions.moveToElement(to);
		actions.click();
		List list=ReadCSV.readfile();
		for(int i=0;i<list.size();i++)
		{
			actions.sendKeys(list.get(i).toString());
			System.out.println(list.get(i));
			actions.sendKeys(" ");
			
		}	
		
		
		actions.build().perform();
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator.findLocator("subject")));

		WebElement subject = driver.findElement(locator.findLocator("subject"));
		subject.sendKeys("Ab milna beta tm log....bhut mail snd kr rhe the na ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator.findLocator("content")));

		WebElement content = driver.findElement(locator.findLocator("content"));
		content.sendKeys("Ab jake automate kr paya :(");

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator.findLocator("sendbutton")));

		WebElement send = driver.findElement(locator.findLocator("sendbutton"));
		send.click();

		System.out.println("Mail sent");

	}
};
