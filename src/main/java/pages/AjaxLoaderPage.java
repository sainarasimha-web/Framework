package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AjaxLoaderPage extends BasePage{
	public AjaxLoaderPage(WebDriver driver) {
		super(driver);
	}
	private By loader = By.id("loader");
	private By clickMeButton=By.xpath("//span[@data-target='#myModalClick']/p[text()='CLICK ME!']");
	private By closeButton=By.xpath("//div[@id='myModalClick']/descendant::button[text()='Close']");
	
	public void waitForInitialLoaderToDisappear() {
		waitUtils.waitForLoaderToDisappear(loader);
	}
	public void clickOnClickMeButton() {
		waitUtils.elementToBeClickable(clickMeButton);
		elementUtils.click(clickMeButton);
	}
	public void clickOnCloseButton() {
		waitUtils.elementToBeClickable(closeButton);
		elementUtils.click(closeButton);
	}
}
