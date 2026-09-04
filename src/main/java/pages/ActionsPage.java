package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsPage extends BasePage{
	public ActionsPage(WebDriver driver) {
		super(driver);
	}
	
	private By src_draggable = By.id("draggable");
	private By tgt_droppable = By.id("droppable");
	private By doubleClickButton = By.xpath("//h2[text()='Double Click Me!']");
	private By MouseHover1=By.xpath("//button[text()='Hover Over Me First!']");
	private By MouseHover2=By.xpath("//button[text()='Hover Over Me Second!']");
	private By MouseHover3=By.xpath("//button[text()='Hover Over Me Third!']");
	private By firstHover_DropdownLink1=By.xpath("//div[@class='dropdown hover']/descendant::a");
	private By secondHover_DropdownLink1=By.xpath("//button[text()='Hover Over Me Second!']/following-sibling::div/a");
	private By thirdHover_DropdownLink1=By.xpath("//button[text()='Hover Over Me Third!']/following-sibling::div/a[text()='Link 1']");
	private By thirdHover_DropdownLink2=By.xpath("//button[text()='Hover Over Me Third!']/following-sibling::div/a[text()='Link 2']");
	private By clickAndHoldButton=By.xpath("//p[text()='Click and Hold!']");
	
	public void dragAndDropElement() {
		actionsUtils.dragAndDrop(src_draggable, tgt_droppable);
	}
	public void doubleClickOnElement() {
		actionsUtils.doubleClick(doubleClickButton);
	}
	public void mouseHover_Hover1() {
		actionsUtils.mouseHover(MouseHover1);
	}
	public void mouseHover_Hover2() {
	    actionsUtils.mouseHover(MouseHover2);
	}
	public void mouseHover_Hover3() {
	    actionsUtils.mouseHover(MouseHover3);
	}
	public void selectFirstHover_DropdownLink1() {
	    actionsUtils.mouseHover(MouseHover1);
	    elementUtils.click(firstHover_DropdownLink1);
	}
	public void selectSecondHover_DropdownLink1() {
	    actionsUtils.mouseHover(MouseHover2);
	    elementUtils.click(secondHover_DropdownLink1);
	}
	public void selectThirdHover_DropdownLink1() {
	    actionsUtils.mouseHover(MouseHover3);
	    elementUtils.click(thirdHover_DropdownLink1);
	}
	public void selectThirdHover_DropdownLink2() {
	    actionsUtils.mouseHover(MouseHover3);
	    elementUtils.click(thirdHover_DropdownLink2);
	}
	public void clickAndHoldButton() {
	    actionsUtils.clickAndHold(clickAndHoldButton);
	}
	
	
}
