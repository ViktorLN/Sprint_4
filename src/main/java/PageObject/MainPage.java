package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By upperOrderButton = By.xpath("html/body/div/div/div/div[1]/div[2]/button[1]");
    private final By lowerOrderButton = By.xpath("html/body/div/div/div/div[4]/div[2]/div[5]/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private  By [] itemsArray;
    private  By [] itemsTextArray;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void creatingItemsArray(){
        int arrayLength =  Integer.parseInt(driver.findElement(By.xpath(".//div[last()]/div[1]/div[@class='accordion__button']")).getAttribute("id").replaceAll("accordion__heading-",""));
        itemsArray = new By[arrayLength+1];
        for (int i = 1; i < itemsArray.length + 1; i++) {
            itemsArray[i-1] = (By.xpath(".//div[" + (i) + "]/div[1]/div[@class='accordion__button']"));
        }
    }

    public void creatingItemsTextArray(){
        itemsTextArray = new By[itemsArray.length];
        for (int i = 1; i < itemsArray.length+1; i++) {
            itemsTextArray[i-1] = By.xpath(".//div["+i+"]/div[2]/p");
        }
    }

    public void clickItem(int numberOfItem){
        creatingItemsArray();
        By element = itemsArray[numberOfItem-1];
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(element));
        driver.findElement(element).click();
    }

    public String getTextOfItem(int numberOfItem){
        creatingItemsTextArray();
        By element = itemsTextArray[numberOfItem-1];
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
