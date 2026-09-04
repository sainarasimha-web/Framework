package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Dropdown_Checkbox_Radiobutton extends BasePage{
	public Dropdown_Checkbox_Radiobutton(WebDriver driver) {
		super(driver);
	}
	
	private By backend_dropdown=By.id("dropdowm-menu-1");
	private By ide_dropdown=By.id("dropdowm-menu-2");
	private By frontend_dropdown=By.id("dropdowm-menu-3");
	
	private By checkbox1=By.xpath("//div[@id='checkboxes']/descendant::input[@value='option-1']");
	private By checkbox2=By.xpath("//div[@id='checkboxes']/descendant::input[@value='option-2']");
	private By checkbox3=By.xpath("//div[@id='checkboxes']/descendant::input[@value='option-3']");
	private By checkbox4=By.xpath("//div[@id='checkboxes']/descendant::input[@value='option-4']");

	private By radioGreen=By.xpath("//form[@id='radio-buttons']/child::input[@value='green']");
	private By radioBlue=By.xpath("//form[@id='radio-buttons']/child::input[@value='blue']");
	private By radioYellow=By.xpath("//form[@id='radio-buttons']/child::input[@value='yellow']");
	private By radioOrange=By.xpath("//form[@id='radio-buttons']/child::input[@value='orange']");
	private By radioPurple=By.xpath("//form[@id='radio-buttons']/child::input[@value='purple']");
	
	//private By radioVegetable_Lattuce=By.xpath("//form[@id='radio-buttons-selected-disabled']/input[@value='lettuce']");
	private By radioVegetable_Cabbage=By.xpath("//form[@id='radio-buttons-selected-disabled']/input[@value='cabbage']");
	//private By radioVegetable_Pumpkin=By.xpath("//form[@id='radio-buttons-selected-disabled']/input[@value='pumpkin']");
	private By fruitsDropdown= By.id("fruit-selects");

	private By disabledOptionOrange=By.xpath("//select[@id='fruit-selects']//option[@value='orange']");
	
	public void selectByVisibleText_FromBackendDropdown( String text ) {
		elementUtils.selectByVisibleText(backend_dropdown, text);
	}
	public void selectByVisibleText_ideDropdown( String text ) {
		elementUtils.selectByVisibleText(ide_dropdown, text);
	}
	public void selectByVisibleText_FromFrontEndDropdown( String text ) {
		elementUtils.selectByVisibleText(frontend_dropdown, text);
	}
	
	public void selectCheckbox1() {
	    elementUtils.selectCheckbox(checkbox1);
	}
	public void selectCheckbox2() {
	    elementUtils.selectCheckbox(checkbox2);
	}
	public void selectCheckbox3() {
	    elementUtils.selectCheckbox(checkbox3);
	}
	public void selectCheckbox4() {
	    elementUtils.selectCheckbox(checkbox4);
	}
	
	public void selectRadioGreen() {
		elementUtils.selectRadioButton(radioGreen);
	}
	public void selectRadioBlue() {
		elementUtils.selectRadioButton(radioBlue);
	}
	public void selectRadioYellow() {
		elementUtils.selectRadioButton(radioYellow);
	}
	public void selectRadioOrange() {
		elementUtils.selectRadioButton(radioOrange);
	}
	public void selectRadioPurple() {
		elementUtils.selectRadioButton(radioPurple);
	}
	
	public void enableRadioVegetable_Cabbage() {
		browserUtils.enableElement(radioVegetable_Cabbage);
		elementUtils.click(radioVegetable_Cabbage);
	}
	
	
	public void enableDropdownValue(String value) {	
		browserUtils.enableElement(disabledOptionOrange);
	    elementUtils.selectByVisibleText(fruitsDropdown, value);
	}
	
}
