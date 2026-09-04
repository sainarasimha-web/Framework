package topics_practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import utils.BrowserUtils;

public class AllElements {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://webdriveruniversity.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
//		contactUsSection(driver, js);
//		loginPortal(driver, js);
		WebElement buttons=driver.findElement(By.id("button-clicks"));
		js.executeScript("arguments[0].click();", buttons);	
		String parent=driver.getWindowHandle();
		Set<String> windowIds=driver.getWindowHandles();
		for(String id:windowIds) {
			if(!id.equals(parent)) {
				driver.switchTo().window(id);
				break;
			}
		}
		driver.findElement(By.xpath("//p[text()='CLICK ME!']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='myModalClick']/descendant::button[text()='Close']")).click();
		
	}

	private static void contactUsSection(WebDriver driver, JavascriptExecutor js) {
		WebElement contactUs=driver.findElement(By.id("contact-us"));
		js.executeScript("arguments[0].click();", contactUs);
		
		String parent=driver.getWindowHandle();
		Set<String> windowIds=driver.getWindowHandles();
		for(String id:windowIds) {
			if(!id.equals(parent)) {
				driver.switchTo().window(id);
				break;
			}
		}
		WebElement firstName=driver.findElement(By.xpath("//input[@name='first_name']"));
		WebElement lastName=driver.findElement(By.xpath("//form[@id='contact_form']/child::input[@name='last_name']"));
		WebElement email=driver.findElement(By.xpath("//form[@id='contact_form']/child::input[@name='email']"));
		WebElement comments=driver.findElement(By.xpath("//form[@id='contact_form']/child::textarea[@name='message']"));
		WebElement submitButton=driver.findElement(By.xpath("//div[@id='form_buttons']/child::input[@type='submit']"));
		
		//Thread.sleep(5000);
		firstName.sendKeys("Sai");
		lastName.sendKeys("Narasimha");
		email.sendKeys("sai123@gmail.com");
		comments.sendKeys("Thanks");
		submitButton.click();
		String msg=driver.findElement(By.xpath("//div[@id='contact_reply']/h1")).getText();
		Assert.assertEquals(msg,"Thank You for your Message!");
	}

	private static void loginPortal(WebDriver driver, JavascriptExecutor js) {
		WebElement loginPortal=driver.findElement(By.xpath("//a[@id='login-portal']"));
		js.executeScript("arguments[0].click();", loginPortal);
		BrowserUtils browser=new BrowserUtils(driver);
		browser.switchToChildWindow();
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		WebElement loginButton=driver.findElement(By.id("login-button"));
		username.sendKeys("SaiNarasimha");
		password.sendKeys("Sai!23@");
		loginButton.click();
		browser.acceptAlert();
	}

	
		
	

}
