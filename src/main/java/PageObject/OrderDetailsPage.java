package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderDetailsPage {
    private final WebDriver driver;
    private final By nameField = By.xpath(".//div/input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//div/input[@placeholder='* Фамилия']");
    private final By deliveryAddressField = By.xpath(".//div/input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField = By.xpath(".//div/input[@placeholder='* Станция метро']");
    private final By phoneNumberField = By.xpath(".//div/input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By orderDetailsConfirmationButton = By.xpath(".//button[text()='Далее']");

    private final By metroRoskovskogo = By.xpath("html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[2]/button");

    public OrderDetailsPage (WebDriver driver){
        this.driver = driver;
    }

    // Все методы которые понадобятся
    public void forWhomScooterInputField(){
        driver.findElement(nameField).sendKeys("ааа");
        driver.findElement(surnameField).sendKeys("Миша");
        driver.findElement(deliveryAddressField).sendKeys("ккккк");
        driver.findElement(phoneNumberField).sendKeys("77777777777");
        driver.findElement(metroStationField).click();
        driver.findElement(metroRoskovskogo).click();
    }

    public void clickOrderDetailsConfirmationButton(){
        driver.findElement(orderDetailsConfirmationButton).click();
        waitMeMyFriend();
    }

    public void waitMeMyFriend()  {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
