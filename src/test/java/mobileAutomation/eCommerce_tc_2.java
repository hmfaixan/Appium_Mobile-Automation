package mobileAutomation;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class eCommerce_tc_2 extends BaseTest {

    @Test
    public void AddToCart() {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("H. M. Faizan");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text = 'Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahrain\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Bahrain']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i=0; i<productCount; i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if (productName.equalsIgnoreCase("Jordan 6 Rings")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }
}
