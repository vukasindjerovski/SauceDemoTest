import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class caseTwoTest {

    @Test
    public void case1() throws InterruptedException {
        System.setProperty("webdriver.chrome.diver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.saucedemo.com/";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(baseUrl);

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("user-name")));

        usernameInput.sendKeys("standard_user");

        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login-button']")));

        loginButton.click();

        WebElement sauceLabsBackpack = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("item_4_title_link")));
        sauceLabsBackpack.click();

        WebElement sauceLabsBackpackElements = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'inventory_details_desc_container')]")));
        sauceLabsBackpackElements.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        sauceLabsBackpackElements.findElement(By.xpath("//*[contains(@class, 'inventory_details_price')]"));
        sauceLabsBackpackElements.findElement(By.xpath("//div[contains(text(), 'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.')]"));
        sauceLabsBackpackElements.findElements(By.id("add-to-cart-sauce-labs-backpack"));

        WebElement addToCard = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        addToCard.click();

        WebElement backToProducts = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("back-to-products")));
        backToProducts.click();

        WebElement sauceLabsFleeceJacket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']")));
        sauceLabsFleeceJacket.click();

        WebElement shopingCard = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'shopping_cart_link')]")));
        shopingCard.click();

        WebElement checkOut = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='checkout']")));
        checkOut.click();

        WebElement form = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'checkout_info_wrapper')]/form")));
        form.findElement(By.xpath("//*[@id='first-name']")).click();
        form.findElement(By.xpath("//*[@id='first-name']")).sendKeys("Vukasin");
        form.findElement(By.xpath("//*[@id='first-name']")).sendKeys(Keys.TAB);
        form.findElement(By.xpath("//*[@id='last-name']")).sendKeys("Djerovski");
        form.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("34000");
        form.findElement(By.xpath("//*[@id='continue']")).click();

        WebElement finishButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='finish']")));
        finishButton.click();

        WebElement thankYouNote = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("complete-header")));
        Assert.assertTrue(thankYouNote.isDisplayed());

        WebElement burgerMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='react-burger-menu-btn']")));
        burgerMenu.click();
        burgerMenu.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();
        Thread.sleep(2500);

        driver.quit();
    }


}