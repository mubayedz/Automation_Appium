package com.qa.actions;

import org.openqa.selenium.support.PageFactory;
import com.qa.locators.HomePageLocators;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePageActions {
	
	HomePageLocators homePageLocators = null;

	public HomePageActions(AndroidDriver<AndroidElement> driver) {
		this.homePageLocators = new HomePageLocators(null);
		PageFactory.initElements(new AppiumFieldDecorator(driver), homePageLocators);
	}

	public void enterName(String name) {
		homePageLocators.inputName().sendKeys(name);

	}
	
	public void selectSex() {
		homePageLocators.selectSex().click();

	}
	
	public void selectDropdown() {
		homePageLocators.clickDropdow().click();
	}
	
	
	public void selectCountry() throws Exception {
		homePageLocators.selectCountry().click();

	}
	
	public void clickButtonShop() {
		homePageLocators.buttonShop().click();

	}
	
	
	
	

}
