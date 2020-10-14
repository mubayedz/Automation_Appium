package practise.AppiumFramework;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import static io.appium.java_client.touch.offset.ElementOption.*;
import static org.testng.Assert.assertEquals;
import static io.appium.java_client.touch.TapOptions.*;
import static io.appium.java_client.touch.LongPressOptions.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.actions.CheckoutPageActions;
import com.qa.actions.HomePageActions;
import com.qa.actions.TestingHybridActions;
import com.qa.actions.Utilities;
import com.qa.locators.FormPageLocators;
import com.qa.locators.HomePageLocators;

import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ecommerce_tc_1 extends base {
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		// taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	@Test
	public void testingEcommerce() throws Exception { // set capabilities as you wish
		AndroidDriver<AndroidElement> driver = capabilities(); // NO UTILIZAMOS NINGUNA APK DE GLOBAL POR QUE USAMOS EL CONSTRUCTOR VACIO
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		HomePageActions homePageActions = new HomePageActions(driver);
		homePageActions.enterName("Sarah Boss");
		driver.hideKeyboard();
		homePageActions.selectSex();
		homePageActions.selectDropdown();
		Utilities u = new Utilities(driver);
		u.scrollToText("Belarus");
		homePageActions.selectCountry();
		homePageActions.clickButtonShop();
        u.scrollToText("Nike SFB Jungle"); // metodo para bajar hasta el texto
		u.iterateProduct("Nike SFB Jungle"); // metodo que itera los productos hasta qeu lo consigue y le da click
		FormPageLocators formPageLocators = new FormPageLocators(driver);
		formPageLocators.addToCart();
		formPageLocators.backToCart();		
		
		//***************** METHOD TO SCROLL WETHER UP OR DOWN ****************
		scroll(driver, 0.5 , 0.2 , 0.2 , 0.8);
		//scroll(driver, startXD, startYD, endXD, endYD);
		//***************************************
		
		u.iterateProduct("Jordan Lift Off"); //metodo que itera los productos hasta qeu lo consigue y le da click
		
		CheckoutPageActions checkoutPageActions = new CheckoutPageActions(driver);
		checkoutPageActions.appbar_btn_cart(); // ** redirected to the cart page
		Thread.sleep(1000);
		
		// ***** Validate One shoe Name 
		String actualNameofShoe = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		assertEquals(actualNameofShoe, "Nike SFB Jungle");
		
		
		//**** Validate One Shoe Price
		String actualPriceofShoe = driver.findElement(By.id("com.androidsample.generalstore:id/productPrice")).getText();
		assertEquals(actualPriceofShoe, "$116.97");
		
		//*** Validate Total Ammount
		String actualTotalAmmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		assertEquals(actualTotalAmmount, "$ 231.97");
		
		//********** Mobile Gestures
		// Tap
		                                                 //android.widget.CheckedTextView[@bounds='[44,1296][1036,1472]']"
		u.mobileTap("//android.widget.CheckBox[@bounds='[44,1712][1019,1800]']");
	
		// Long Press
		u.mobileLongPress("//*[@text='Please read our terms of conditions']");

		checkoutPageActions.closePopup();
		checkoutPageActions.clickProceed();
	    
	    //********* Hybrid APP **********
	    Set<String> contexts = driver.getContextHandles();
	    for (String contextName : contexts) {
	        System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
	    }
	    Thread.sleep(5000);  // EL VALOR APARECE ES EN EL PACKAGE DE APPIUM EMULADOR "com.androidsample.generalstore" 
	    driver.context("WEBVIEW_com.androidsample.generalstore"); // COLOCO EL VALOR QUE IMPRIMIRA
	    Thread.sleep(9000);

	    /*TestingHybridActions testingHybridActions = new TestingHybridActions(driver);
	    Thread.sleep(1000);
	    testingHybridActions.closePopGoogle();
	    testingHybridActions.writeSearchGoogle("Pizza con");
	    */
	    driver.findElement(By.xpath("//*[@id='cnskx']")).click();
	    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Pizza con"); // envia resultados
	    
	    u.iterateGoogleSearchBar("pizza con huevo"); // itera y dara click en la lista de busqueda
	    
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); // le dara click back para volver a la app nativa
		driver.context("NATIVE_APP"); // cambiara el contexto otra vez a nativo
		//testingHybridActions.clickShop();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); // click botton

	}
	//Swipe by elements >> Method to scroll down
    public static void scroll (AndroidDriver<AndroidElement> driver, double startXD, double startYD, double endXD, double endYD) {
        Dimension dimension = driver.manage().window().getSize();
    	int startX = (int) (dimension.width * startXD); // 0.5
        int startY = (int)  (dimension.height * startYD); //0.2
 
        int endX = (int) (dimension.width * endXD); //0.2
        int endY = (int) (dimension.height * endYD); //0.8
 
        TouchAction touch = new TouchAction(driver);
                touch.press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY)).release().perform();
    }
		/********************** COMMAND TO CLICK ON A ELEMENT BY THE BOUND
		 * WebElement abc = driver.findElement(By.xpath ("//android.widget.ImageButton[@bounds='[9,288][144,318]']"))

           abc.click();
		 */

		// --------------- COMMAND TO PRINT THE MESSAGE OF ERROR ---- USE
		// android.widget.Toast[1] it will print the first error message
		// String toastMessage =
		// driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		// System.out.println(toastMessage);

		// --------- COMMAND TO SCROLL DOWN IF THE FIRST ONE DOESN'T WORK
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textMatches(\"" + containedText + "\").instance(0))"));

	}


