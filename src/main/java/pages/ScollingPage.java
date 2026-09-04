package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScollingPage extends BasePage{
	public ScollingPage(WebDriver driver) {
		super(driver);
	}
	
	private By scrollZone1=By.xpath("//div[@id='zone1']/h1");
	private By scrollZone2=By.xpath("//div[@id='zone2']/h1");
	private By afterScrollText =By.xpath("//div[text()='Well done for scrolling to me!']");
	private By scrollZone3=By.xpath("//div[@id='zone3']/h1");
	private By scrollZone4=By.xpath("//div[@id='zone4']/h1");
	
	public String getTextBeforScroll() {
	    return elementUtils.getText(scrollZone1);
	}
	public void scrollToZone1() {
	    actionsUtils.mouseHover(scrollZone1);
	}
	public String getTextAfterScroll() {
		return elementUtils.getText(afterScrollText);
	}
	public void scrollToZone2() {
	    actionsUtils.mouseHover(scrollZone2);
	}
	

	public void scrollToZone3() {
	    actionsUtils.mouseHover(scrollZone3);
	}

	public void scrollToZone4() {
	    actionsUtils.mouseHover(scrollZone4);
	}
}
