import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        // Установка пути к geckodriver.exe
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Пётр\\OneDrive\\Рабочий стол\\4 семестр\\Информационка\\Lab5\\SeleniumAndWebDriver\\GeckoDriver\\geckodriver.exe");

        // Инициализация экземпляра WebDriver для Firefox
        WebDriver driver = new FirefoxDriver();

        // Переход на главную страницу сайта
        driver.get("https://testng.org/");

        // Закрытие браузера
        driver.quit();
    }
}
