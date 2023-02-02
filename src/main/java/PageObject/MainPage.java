package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    // Переменная типа String для работы с общим путём всех Item,
    // в методе вместо N будет подставляться необходимый номер Item
    private final String allPath = "html/body/div/div/div/div[5]/div[2]/div/div[N]/div[2]/p";
    private final By upperOrderButton = By.xpath("html/body/div/div/div/div[1]/div[2]/button[1]");
    private final By lowerOrderButton = By.xpath("html/body/div/div/div/div[4]/div[2]/div[5]/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickItem(int numberOfItem){
        By element = By.xpath(allPath.replace('N',Integer.toString(numberOfItem).charAt(0))
        +"/parent::div/parent::div");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(element));
        driver.findElement(element).click();
    }

    public String getTextOfItem(int numberOfItem){
        By element = By.xpath(allPath.replace('N',Integer.toString(numberOfItem).charAt(0)));
        // Ожижание отображения теста
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    public void clickOrderButton(By by){
       driver.findElement(By.xpath("html/body/div/div/div[2]/div/div[2]/button")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(by));
        driver.findElement(by).click();
    }

    public By getUpperOrderButton() {
        return upperOrderButton;
    }

    public By getLowerOrderButton() {
        return lowerOrderButton;
    }
}
