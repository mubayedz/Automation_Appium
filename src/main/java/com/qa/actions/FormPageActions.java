package com.qa.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.locators.FormPageLocators;
import com.qa.locators.HomePageLocators;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPageActions {
	FormPageLocators formPageLocators = null;

	public FormPageActions(AndroidDriver<AndroidElement> driver) {
		this.formPageLocators = new FormPageLocators(null);
		PageFactory.initElements(new AppiumFieldDecorator(driver), formPageLocators);
	}

	public void addToCart() throws Exception {
		formPageLocators.addToCart().click();
		Thread.sleep(1500);

	}
	
	public void backToCart() throws Exception {
		formPageLocators.backToCart().click();
		Thread.sleep(1000);

	}
}
