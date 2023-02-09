package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDatePage {
    private final WebDriver driver;
    private final By deliveryDateField = By.xpath("html/body/div/div/div[2]/div[2]/div[1]/div/div/input");
    private final By secondOfFebruary = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[4]");
    private final By rentalPeriodField = By.xpath("html/body/div/div/div[2]/div[2]/div[2]");
    private final By oneDayPeriodSelected = By.xpath("html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    private final By finishOrderingButton = By.xpath("html/body/div/div/div[2]/div[3]/button[2]");
    private final By acceptOrderButton = By.xpath("html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    private final By popupWindowSuccessfulFinishOrdering = By.xpath("html/body/div/div/div[2]/div[5]/div[1]");

    public OrderDatePage (WebDriver driver){
        this.driver = driver;
    }

    // Все методы которые понадобятся
    public void inputDateOrder (){
        driver.findElement(deliveryDateField).click();
        driver.findElement(secondOfFebruary).click();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(oneDayPeriodSelected).click();
        driver.findElement(finishOrderingButton).click();
        driver.findElement(acceptOrderButton).click();
    }

    public String checkPopupWindow(){
        return driver.findElement(popupWindowSuccessfulFinishOrdering).getText();

    }
}
