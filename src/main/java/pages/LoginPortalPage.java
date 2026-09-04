package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPortalPage extends BasePage{
	public LoginPortalPage(WebDriver driver) {
		super(driver);
	}
	
	private By username=By.xpath("//input[@placeholder='Username']");
	private By password=By.xpath("//input[@placeholder='Password']");
	private By loginButton=By.id("login-button");
	
	public void enterUserName(String value) {
		elementUtils.sendKeys(username, value);
	}
	public void enterPassword(String value) {
		elementUtils.sendKeys(password, value);
	}
	public void clickOnLoginButton() {
		elementUtils.click(loginButton);
	}
}