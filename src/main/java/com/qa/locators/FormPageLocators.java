package com.qa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPageLocators {
	public FormPageLocators(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_back")
	public WebElement backToCart;
	
	public WebElement addToCart() {
		return addToCart;
	}
	
	public WebElement backToCart() {
		return backToCart;
	}

}
