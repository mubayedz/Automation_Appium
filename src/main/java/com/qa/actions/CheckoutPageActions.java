package com.qa.actions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.locators.CheckoutPageLocators;
import com.qa.locators.HomePageLocators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPageActions {
	CheckoutPageLocators checkoutPageLocators = null;

	public CheckoutPageActions(AndroidDriver<AndroidElement> driver) {
		this.checkoutPageLocators = new CheckoutPageLocators(null);
		PageFactory.initElements(new AppiumFieldDecorator(driver), checkoutPageLocators);
	}
	
	public void appbar_btn_cart() {
		checkoutPageLocators.appbar_btn_cart().click();

	}

	public void actualNameofShoe() {
		checkoutPageLocators.actualNameofShoe().getText();

	}
	
	public String actualNameofShoe1()
	{
		String actualNameofShoe = checkoutPageLocators.actualNameofShoe().getText();
	    return actualNameofShoe;
	}
	
	public void actualPriceofShoe() {
		checkoutPageLocators.actualPriceofShoe().getText();

	}
	
	public void actualTotalAmmount() {
		checkoutPageLocators.actualTotalAmmount().getText();

	}
	
	public void clickCheckBox() {
		checkoutPageLocators.clickCheckBox().click();

	}
	
	public void longPress() {
		checkoutPageLocators.longPress();

	}
	
	public void Tap() {


	}
	
	public void closePopup() {
		checkoutPageLocators.closePopup().click();

	}
	
	public void clickProceed() {
		checkoutPageLocators.clickProceed().click();

	}
	
	
}
