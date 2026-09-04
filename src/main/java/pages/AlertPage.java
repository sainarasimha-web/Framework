package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage{

	public AlertPage(WebDriver driver) {
		super(driver);
	}
	
	By normalAlert=By.id("button1");
	By popup=By.id("button2");
	By closebutton_popup=By.xpath("//button[@class='btn btn-default' and text()='Close']");
	By ajaxPopup=By.id("button3");
	By loader=By.id("loader");
	By clickMeButton=By.xpath("//p[text()='CLICK ME!']");
	By closeButton_ajaxClick=By.xpath("//button[@class='btn btn-default']");
	By confirmationAlert=By.id("button4");
	By msg=By.id("confirm-alert-text");
	
	public void clickOnNormalAlert() {
		elementUtils.click(normalAlert);
	}
	public void clickOnPopupButton() {
		elementUtils.click(popup);
	}
	public void clickOnCloseButton_popup() {
		waitUtils.elementToBeClickable(closebutton_popup);
		elementUtils.click(closebutton_popup);
	}
	public void clickOnAjaxPopup() {
		waitUtils.waitForLoaderToDisappear(loader);
		elementUtils.click(ajaxPopup);
	}
	public void clickOnAjax_ClickMeButton() {
		waitUtils.elementToBeClickable(clickMeButton);
		elementUtils.click(clickMeButton);
	}
	public void clickOnAjaxCloseButton() {
		waitUtils.elementToBeClickable(closeButton_ajaxClick);
		elementUtils.click(closeButton_ajaxClick);
	}
	public void clickOnConfirmationAlert() {
		elementUtils.click(confirmationAlert);
	}
	public String getMsg() {
		return elementUtils.getText(msg);
	}

}
