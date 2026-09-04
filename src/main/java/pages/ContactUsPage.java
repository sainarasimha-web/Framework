package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactUsPage extends BasePage{
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	private By firstName=By.xpath("//input[@name='first_name']");
	private By lastName=By.xpath("//form[@id='contact_form']/child::input[@name='last_name']");
	private By email=By.xpath("//form[@id='contact_form']/child::input[@name='email']");
	private By comments=By.xpath("//form[@id='contact_form']/child::textarea[@name='message']");
	private By submitButton=By.xpath("//div[@id='form_buttons']/child::input[@type='submit']");
	private By successMessage=By.xpath("//div[@id='contact_reply']/h1");
	
	public void enterFirstName(String value) {
		elementUtils.sendKeys(firstName, value);
	}
	public void enterLastName(String value) {
		elementUtils.sendKeys(lastName, value);
	}
	public void enterEmail(String value) {
		elementUtils.sendKeys(email, value);
	}
	public void enterComments(String value) {
		elementUtils.sendKeys(comments, value);
	}
	public void clickOnSubmitButton() {
		elementUtils.click(submitButton);
	}
	public String getSuccessMessage() {
		return elementUtils.getText(successMessage);
	}
}
