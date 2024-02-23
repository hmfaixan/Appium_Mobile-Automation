package mobileAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public UiAutomator2Options options;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\Faizan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		options = new UiAutomator2Options();
		options.setDeviceName("MyPhone");
		options.setApp(
				"C:\\Users\\Faizan\\Desktop\\Eclipse Folder\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		service.start();

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void LongPressAction(WebElement element) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(), "duration", 2000));
	}
	
	public void ScrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0));
		}
		while (canScrollMore);
	}
		
	public void SwipeAction(WebElement Image, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)Image).getId(),
			    "direction", direction,
			    "percent", 0.2
			));
	}
	
	public void DragDropAction(WebElement source) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 650,
			    "endY", 585
			));
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
		service.stop();
	}

}
