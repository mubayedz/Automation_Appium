package com.qa.locators;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;

public class CheckoutPageLocators {
	public CheckoutPageLocators(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//********** PAGE FACTORY

	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement appbar_btn_cart;

	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public WebElement actualNameofShoe;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public WebElement actualPriceofShoe;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement actualTotalAmmount;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox[@bounds='[44,1712][1019,1800]']")
	public WebElement clickCheckBox;
	
	@AndroidFindBy(xpath="//*[@text='Please read our terms of conditions']")
	public WebElement longPress;
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement closePopup;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement clickProceed;
	
	public WebElement appbar_btn_cart() {
		return appbar_btn_cart;
	}
	
	public WebElement actualNameofShoe() {
		return actualNameofShoe;
	}
	
	public WebElement actualPriceofShoe() {
		return actualPriceofShoe;
	}
	
	public WebElement actualTotalAmmount() {
		return actualTotalAmmount;
	}
	
	public WebElement clickCheckBox() {
		return clickCheckBox;
	}
	
	public WebElement longPress() {
		return longPress;
	}
	
	public WebElement closePopup() {
		return closePopup;
	}
	
	public WebElement clickProceed() {
		return clickProceed;
	}

}
