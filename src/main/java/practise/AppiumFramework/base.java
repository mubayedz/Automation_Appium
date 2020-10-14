package practise.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	public static Properties prop;

	public AppiumDriverLocalService startServer() {
		//
		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;

	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static void startEmulator() throws IOException, InterruptedException {

		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}

	public static AndroidDriver<AndroidElement> capabilities() throws IOException, InterruptedException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
		prop.load(fis);

		// TODO Auto-generated method stub
		File appDir = new File("src");
		// File app = new File(appDir, (String) prop.get(appName));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// String device = System.getProperty("deviceName"); // Jenkins
		String device = prop.getProperty("deviceName"); // Maven en mi caso funciono tambien en jenkins
		if (device.contains("emulator")) {
			startEmulator();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
			// capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		} else if (device.equals("real")) {
			capabilities.setCapability("deviceName", "pizzamam");
			capabilities.setCapability("udid", "a9394c3e0211"); // escribo "adb deviceadbs" en la consola y con ese
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "8.1.0 O11019");
			capabilities.setCapability("appPackage", "com.androidsample.generalstore"); // >> you must edit both
																						// appPackage and appActivity
			capabilities.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
			capabilities.setCapability("chromedriverExecutable",
					"C:\\Users\\mubayed\\Desktop\\SELENIUM 4.0\\chromedriver.exe");
		} else if (device.equals("chrome_browser")) {
			capabilities.setCapability("deviceName", "pizzamam");
			capabilities.setCapability("udid", "a9394c3e0211");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "8.1.0 O11019");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("chromedriverExecutable",
					"C:\\Users\\mubayed\\Desktop\\SELENIUM 4.0\\chromedriver.exe");
			// cap.setCapability("noReset", true);
		}
		capabilities.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability("autoGrantPermissions", "true");
		capabilities.setCapability("autoDismissAlerts", "true");

		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		return driver;
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
		prop.load(fis);

		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(appName));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// String device = System.getProperty("deviceName"); // Jenkins
		String device = prop.getProperty("deviceName"); // Maven
		if (device.contains("emulator")) {
			startEmulator();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		} else if (device.equals("real")) {
			capabilities.setCapability("deviceName", "pizzamam");
			capabilities.setCapability("udid", "a9394c3e0211"); // escribo "adb deviceadbs" en la consola y con ese
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "8.1.0 O11019");
			capabilities.setCapability("appPackage", "com.androidsample.generalstore"); // >> you must edit both
																						// appPackage and appActivity
			capabilities.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
			capabilities.setCapability("chromedriverExecutable",
					"C:\\Users\\mubayed\\Desktop\\SELENIUM 4.0\\chromedriver.exe");
		} else if (device.equals("chrome_browser")) {
			capabilities.setCapability("deviceName", "pizzamam");
			capabilities.setCapability("udid", "a9394c3e0211");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "8.1.0 O11019");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("chromedriverExecutable",
					"C:\\Users\\mubayed\\Desktop\\SELENIUM 4.0\\chromedriver.exe");
			// cap.setCapability("noReset", true);
		}
		capabilities.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability("autoGrantPermissions", "true");
		capabilities.setCapability("autoDismissAlerts", "true");

		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		return driver;
	}

	public static void getScreenshot(String s) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));

	}

}
