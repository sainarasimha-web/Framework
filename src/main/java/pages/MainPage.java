package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage{
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	private By contactUsSection=By.id("contact-us");
	private By loginPortalSection=By.xpath("//a[@id='login-portal']");
	private By buttonClicks=By.id("button-clicks");
	private By dd_checkBox_radioButtons=By.id("dropdown-checkboxes-radiobuttons");
	private By ajaxLoader=By.id("ajax-loader");
	private By actionsSection=By.id("actions");
	private By scrollingSection=By.id("scrolling-around");
	private By alertsSection=By.id("popup-alerts");
	
	public void clickOnContactUsSection() {
		browserUtils.jsClick(contactUsSection);
	}
	
	public void clickOnLoginPortalSection() {
		browserUtils.jsClick(loginPortalSection);
	}
	
	public void clickOnButtonClicksSecion() {
		browserUtils.jsClick(buttonClicks);
	}
	
	public void clickOnDropdownSection() {
		browserUtils.jsClick(dd_checkBox_radioButtons);
	}
	public void clickOnAjaxLoaderSection() {
		browserUtils.jsClick(ajaxLoader);
	}
	public void clickOnActionsSection() {
		browserUtils.jsClick(actionsSection);
	}
	public void clickOnScrollingSection() {
		browserUtils.jsClick(scrollingSection);
	}
	public void clickOnAlertsSection() {
		browserUtils.jsClick(alertsSection);
	}
}
