package epamlviv1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import org.apache.commons.io.FileUtils;


import javax.swing.text.html.CSS;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SeleniumTest1a {

    @Test
    public void  verifyRozetkaImages() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://www.rozetka.com.ua/");

        TakesScreenshot screenshot1 = (TakesScreenshot)driver;
        File sourse1 = screenshot1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourse1,new File("./Screenshots/rozetkaNavigate.png"));
        System.out.println("Screenshot1 taken");

        WebElement webElement = driver.findElement(By.name("search"));
        webElement.sendKeys("iphone 12 pro max" + Keys.ENTER);
        List<WebElement> imageList = wait.until(presenceOfAllElementsLocatedBy(By.xpath("//img[@class]")));
        WebElement image = imageList.get(0);
        boolean imagePresent = image.isDisplayed();
        System.out.println(imagePresent);
        Assert.assertTrue(imagePresent,"The image is exist");

        TakesScreenshot screenshot2 = (TakesScreenshot)driver;
        File sourse2 = screenshot2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourse2,new File("./Screenshots/rozetkaImage.png"));
        System.out.println("Screenshot2 taken");

        driver.quit();}


}

