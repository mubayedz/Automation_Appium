package com.qa.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePageLocators {
	public HomePageLocators(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//********** PAGE FACTORY
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement inputName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	public WebElement selectSex;
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement clickDropdown;
	
	@AndroidFindBy(xpath="//*[@text='Belarus']")
	public WebElement selectCountry;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement buttonShop;
	
	public WebElement inputName() {
		return inputName;
	}
	
	public WebElement selectSex() {
		return selectSex;
	}
	
	public WebElement clickDropdow() {
		return clickDropdown;
	}
	
	public WebElement selectCountry() {
		return selectCountry;
	}
	
	public WebElement buttonShop() {
		return buttonShop;
	}

}
