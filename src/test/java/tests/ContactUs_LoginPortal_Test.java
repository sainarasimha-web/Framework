package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataproviders.ExcelDataProvider;
import pages.ActionsPage;
import pages.AjaxLoaderPage;
import pages.AlertPage;
import pages.ButtonClicksPage;
import pages.ContactUsPage;
import pages.Dropdown_Checkbox_Radiobutton;
import pages.LoginPortalPage;
import pages.MainPage;
import pages.ScollingPage;
import utils.BrowserUtils;

public class ContactUs_LoginPortal_Test extends BaseTest{
	@Test
	public void ContactUsTest() {
		MainPage mainpage=new MainPage(driver);
		mainpage.clickOnContactUsSection();
		
		BrowserUtils browserutils=new BrowserUtils(driver);
		browserutils.switchToChildWindow();
		
		ContactUsPage contactUspage=new ContactUsPage(driver);
		contactUspage.enterFirstName("Sai");
		contactUspage.enterLastName("Narasimha");
		contactUspage.enterEmail("Sai123@gmail.com");
		contactUspage.enterComments("Just Now Started Feveloping Framweork");
		contactUspage.clickOnSubmitButton();
	}
	@Test(
		    dataProvider = "loginData",
		    dataProviderClass = ExcelDataProvider.class
		)
	public void LoginPortalTest(String username, String password, String expectedResult) {
		MainPage mainpage=new MainPage(driver);
		mainpage.clickOnLoginPortalSection();
		
		BrowserUtils browserutils=new BrowserUtils(driver);
		browserutils.switchToChildWindow();
		
		LoginPortalPage loginportalpage=new LoginPortalPage(driver);
		loginportalpage.enterUserName(username);
		loginportalpage.enterPassword(password);
		loginportalpage.clickOnLoginButton();
//		Assert.fail("Testing retry mechanism");
//		Assert.assertTrue(false);
		browserutils.acceptAlert();
	}
	@Test
	public void ButonsClickSections_Test(){
		MainPage mainpage=new MainPage(driver);
		mainpage.clickOnButtonClicksSecion();
		
		BrowserUtils browserUtils=new BrowserUtils(driver);
		browserUtils.switchToChildWindow();
		
		ButtonClicksPage buttonsClickspage=new ButtonClicksPage(driver);
		buttonsClickspage.clickOnNormalClickButton();
		buttonsClickspage.clickOnCancelButton();
		
		buttonsClickspage.clickOnJsClickButton();
		buttonsClickspage.clickOnJsCancelButton();
		
		buttonsClickspage.clickOnActionsClickButton();
		buttonsClickspage.clickOnActionsCancelButton();
	}
	@Test
	public void Dropdown_Checkbox_RadioButtons_Test() {
		MainPage mainpage=new MainPage(driver);
		mainpage.clickOnDropdownSection();
		
		BrowserUtils browserUtils=new BrowserUtils(driver);
		browserUtils.switchToChildWindow();
		
		Dropdown_Checkbox_Radiobutton dcr=new Dropdown_Checkbox_Radiobutton(driver);
		dcr.selectByVisibleText_FromBackendDropdown("JAVA");
		dcr.selectByVisibleText_ideDropdown("Eclipse");
		dcr.selectByVisibleText_FromFrontEndDropdown("CSS");
		
		dcr.selectCheckbox1();
		dcr.selectCheckbox2();
		dcr.selectCheckbox3();
		dcr.selectCheckbox4();
		
		dcr.selectRadioBlue();
		
		dcr.enableRadioVegetable_Cabbage();
		
		dcr.enableDropdownValue("Orange");		
	}
	@Test
	public void AjaxLoaderTest() throws InterruptedException {
		MainPage mainpage=new MainPage(driver);
		mainpage.clickOnAjaxLoaderSection();
		
		BrowserUtils browserutils=new BrowserUtils(driver);
		browserutils.switchToChildWindow();
		
		AjaxLoaderPage ajaxloader=new AjaxLoaderPage(driver);
		Assert.fail("Testing retry mechanism");
		ajaxloader.waitForInitialLoaderToDisappear();
		ajaxloader.clickOnClickMeButton();
		ajaxloader.clickOnCloseButton();
	}
	@Test
	public void ActionsTest() {
		MainPage mainpage=new MainPage(driver);
		mainpage.clickOnActionsSection();
		
		BrowserUtils browserUtils=new BrowserUtils(driver);
		browserUtils.switchToChildWindow();
		
		ActionsPage actionspage=new ActionsPage(driver);
		actionspage.dragAndDropElement();
		actionspage.doubleClickOnElement();
		actionspage.selectFirstHover_DropdownLink1();
		browserUtils.acceptAlert();
		actionspage.selectSecondHover_DropdownLink1();
		browserUtils.acceptAlert();
		actionspage.selectThirdHover_DropdownLink1();
		browserUtils.acceptAlert();
		actionspage.selectThirdHover_DropdownLink2();
		browserUtils.acceptAlert();
		actionspage.clickAndHoldButton();
	}
	@Test
	public void ScrollingTest() {
		MainPage mainpage=new MainPage(driver);
		mainpage.clickOnScrollingSection();
		
		BrowserUtils browserutils=new BrowserUtils(driver);
		browserutils.switchToChildWindow();
		
		ScollingPage scrollingpage=new ScollingPage(driver);
		String msgBeforeScroll=scrollingpage.getTextBeforScroll();
		Assert.assertEquals(msgBeforeScroll, "Scroll to me first!");
		scrollingpage.scrollToZone1();
		String msgAfterScroll=scrollingpage.getTextAfterScroll();
		Assert.assertEquals(msgAfterScroll, "Well done for scrolling to me!");
		scrollingpage.scrollToZone2();
		scrollingpage.scrollToZone3();
		scrollingpage.scrollToZone4();
	}
	@Test
	public void AlertsTest() {
		MainPage mainpage=new MainPage(driver);
		mainpage.clickOnAlertsSection();

		BrowserUtils browserutils=new BrowserUtils(driver);
		browserutils.switchToChildWindow();
		
		AlertPage alertpage=new AlertPage(driver);
		alertpage.clickOnNormalAlert();
		browserutils.acceptAlert();
		
		alertpage.clickOnPopupButton();
		alertpage.clickOnCloseButton_popup();
		
		alertpage.clickOnAjaxPopup();
		alertpage.clickOnAjax_ClickMeButton();
		alertpage.clickOnAjaxCloseButton();
		browserutils.navigateBack();
		
		alertpage.clickOnConfirmationAlert();
		browserutils.acceptAlert();
		System.out.print(alertpage.getMsg());
		Assert.assertEquals(alertpage.getMsg(), "You pressed OK!");
	}
	
}
