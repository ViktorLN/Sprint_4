import PageObject.MainPage;
import PageObject.OrderDatePage;
import PageObject.OrderDetailsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckingOrderTest {
    private WebDriver driver;
    private final By orderButton;

    public CheckingOrderTest(By orderButton) {
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        MainPage mainPageObj = new MainPage(null);
        return new Object[][] {
                {mainPageObj.getLowerOrderButton()},
                {mainPageObj.getUpperOrderButton()},
        };
    }

    @Test
    public void checkPopupWindowTestCompletingRequiredFieldsWithSecondOrderButtonShowTrue(){
        String expected = "Заказ оформлен";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButton(orderButton);
        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.forWhomScooterInputField();
        orderDetailsPage.clickOrderDetailsConfirmationButton();

        OrderDatePage orderDatePage = new OrderDatePage(driver);
        orderDatePage.inputDateOrder();

        String actual = orderDatePage.checkPopupWindow();
        Assert.assertEquals("Не обнаружено уведомление об успешном оформлении заказа",expected, actual);
    }

    @After
    public void teardown() {
        // Закрытие браузера
            driver.quit();
    }
}
