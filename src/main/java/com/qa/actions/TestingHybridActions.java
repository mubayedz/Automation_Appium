package com.qa.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.locators.HomePageLocators;
import com.qa.locators.TestingHybridLocators;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TestingHybridActions {

	TestingHybridLocators testingHybridLocators = null;

	public TestingHybridActions(AndroidDriver<AndroidElement> driver) {
		this.testingHybridLocators = new TestingHybridLocators(null);
		PageFactory.initElements(new AppiumFieldDecorator(driver), testingHybridLocators);
	}

	public void closePopGoogle() {
		testingHybridLocators.closePopGoogle().click();

	}
	
	public void writeSearchGoogle(String text) {
		testingHybridLocators.writeSearchGoogle().sendKeys(text);

	}
	
	public void clickShop() {
		testingHybridLocators.clickShop().click();
	}
}
