package com.qa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TestingHybridLocators {
	public TestingHybridLocators(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//********** PAGE FACTORY
	
	@AndroidFindBy(xpath="//*[@id='cnskx']")
	public WebElement closePopGoogle;
	
	@AndroidFindBy(xpath="//input[@name='q']")
	public WebElement writeSearchGoogle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement clickShop;

	
	public WebElement closePopGoogle() {
		return closePopGoogle;
	}
	
	public WebElement writeSearchGoogle() {
		return writeSearchGoogle;
	}
	
	public WebElement clickShop() {
		return clickShop;
	}
}
