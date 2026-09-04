package pages;

import org.openqa.selenium.WebDriver;

import utils.ActionsUtils;
import utils.BrowserUtils;
import utils.ElementUtils;
import utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;

    protected ElementUtils elementUtils;
    protected BrowserUtils browserUtils;
    protected ActionsUtils actionsUtils;    
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        this.elementUtils = new ElementUtils(driver);
        this.browserUtils = new BrowserUtils(driver);
        this.actionsUtils = new ActionsUtils(driver);
        this.waitUtils = new WaitUtils(driver);
    }
}