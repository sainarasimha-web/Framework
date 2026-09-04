package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonClicksPage extends BasePage{
	
	public ButtonClicksPage(WebDriver driver) {
		super(driver);
	}
	
	By normalClick=By.xpath("//p[text()='CLICK ME!']");
	By cancelButton=By.xpath("//div[@id='myModalClick']/descendant::button[text()='Close']");
	By jsClickButon=By.xpath("//span[text()='CLICK ME!!']");
	By jsCancelButton=By.xpath("//div[@id='myModalJSClick']/descendant::button[text()='Close']");
	By actionsClickButton=By.xpath("//span[text()='CLICK ME!!!']");
	By actionsCancelButton=By.xpath("//div[@id='myModalMoveClick']/descendant::button[text()='Close']");
	
	public void clickOnNormalClickButton() {
		elementUtils.click(normalClick);
	}
	public void clickOnCancelButton() {
		waitUtils.elementToBeClickable(cancelButton);
		elementUtils.click(cancelButton);
	}
	
	public void clickOnJsClickButton() {
		browserUtils.jsClick(jsClickButon);
	}
	public void clickOnJsCancelButton() {
		waitUtils.elementToBeClickable(jsCancelButton);
		elementUtils.click(jsCancelButton);
	}
	
	public void clickOnActionsClickButton() {
		actionsUtils.mouseHover(actionsClickButton);
		elementUtils.click(actionsClickButton);
	}
	public void clickOnActionsCancelButton() {
		waitUtils.elementToBeClickable(actionsCancelButton);
		elementUtils.click(actionsCancelButton);
	}
}
