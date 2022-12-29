import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class caseOneTest {
    @Test
    public void case1() throws InterruptedException {
        System.setProperty("webdriver.chrome.diver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");

        WebDriver driver =  new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(baseUrl);



        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));



        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("user-name")));

        usernameInput.sendKeys("standard_user");

        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login-button']")));

        loginButton.click();


        WebElement productsHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Products']")));
        Assert.assertTrue(productsHeader.isDisplayed());

        WebElement shoppingCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("shopping_cart_link")));
        Assert.assertTrue(shoppingCart.isDisplayed());

        WebElement burgerMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-burger-menu-btn")));
        Assert.assertTrue(burgerMenu.isDisplayed());

//        WebElement socialBtnTwitter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Twitter']")));
//        Assert.assertEquals(true, socialBtnTwitter.isDisplayed());

        WebElement twitterBtn = driver.findElement(By.className("social_twitter"));
        WebElement facebookBtn = driver.findElement(By.className("social_facebook"));
        WebElement linkedInBtn = driver.findElement(By.className("social_linkedin"));

        Assert.assertEquals(true, twitterBtn.isDisplayed());
        Assert.assertEquals(true, facebookBtn.isDisplayed());
        Assert.assertEquals(true, linkedInBtn.isDisplayed());

        Thread.sleep(2500);
        burgerMenu.click();

        WebElement logOut = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='logout_sidebar_link']")));
        logOut.click();

        driver.quit();
    }



}