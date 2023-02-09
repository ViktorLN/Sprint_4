import PageObject.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class QuestionsAboutImportantTests {
    private WebDriver driver;
    private final boolean expected;
    private final int numberOfItem;
    private final String checkedText;

    public QuestionsAboutImportantTests(boolean expected, int numberOfItem, String checkedText){
        this.expected = expected;
        this.numberOfItem = numberOfItem;
        this.checkedText = checkedText;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {true, 1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {true, 2,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {true, 3,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {true, 4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {true, 5,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {true, 6,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {true, 7,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {true, 8,"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
                {false, 1, ""},
        };
    }

    @Before
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void getTextOfItemWhenNumberOfItemIsTrue() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Клик по Item
        MainPage myObject = new MainPage(driver);
        myObject.clickItem(numberOfItem);
        // получение текста Item
        String actualText = myObject.getTextOfItem(numberOfItem);
        boolean actual = actualText.equals(checkedText);
        Assert.assertEquals("Текст не соотвествует номеру Item",expected, actual);
    }

    @After
    public void teardown() {
        // Закрытие браузера
            driver.quit();
    }
}