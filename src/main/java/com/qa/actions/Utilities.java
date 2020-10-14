package com.qa.actions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

public class Utilities {
	AndroidDriver<AndroidElement> driver;

	public Utilities(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}

	public void mobileTap(String text) {
		MobileElement clickCheckBox = driver.findElement(By.xpath(text));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(clickCheckBox))).perform();
	}

	public void mobileLongPress(String text) {
		MobileElement longPress = driver.findElement(By.xpath(text));
		TouchAction t = new TouchAction(driver);
		t.longPress(
				LongPressOptions.longPressOptions().withElement(element(longPress)).withDuration(Duration.ofSeconds(3)))
				.release().perform();
	}

	
	public void iterateProduct(String productName) throws Exception {
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size(); // contara los
																										// elementos con
																										// productname

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (text.equalsIgnoreCase(productName)) // cuando consiga el item con el nombre le dara click
			{
				Thread.sleep(1500);
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
	}

	public void iterateGoogleSearchBar(String textList) throws Exception {
		int countList = driver.findElements(By.xpath("//li[@jsname='IrQt0b']")).size(); // contara los elementos en la
																						// lista

		for (int i = 0; i < countList; i++) {
			String text = driver.findElements(By.xpath("//li[@jsname='IrQt0b']")).get(i).getText();
			if (text.equalsIgnoreCase(textList)) // cuando consiga el item con el nombre le dara
																		// click
			{
				Thread.sleep(1000);
				driver.findElements(By.xpath("//li[@jsname='IrQt0b']")).get(i).click();
				break;
			}
		}
	}
}
