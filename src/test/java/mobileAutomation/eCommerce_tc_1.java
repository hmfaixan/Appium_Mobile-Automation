package mobileAutomation;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_1 extends BaseTest {

    @Test
    public void fillForm() {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("H. M. Faizan");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text = 'Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahrain\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Bahrain']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

//        Get Toast Message
//        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//        Assert.assertEquals(toastMessage, "Please enter your name");

    }
}
