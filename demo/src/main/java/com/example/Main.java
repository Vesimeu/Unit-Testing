import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
        // Установка пути к geckodriver.exe
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Пётр\\OneDrive\\Рабочий стол\\4 семестр\\Информационка\\Lab5\\SeleniumAndWebDriver\\GeckoDriver\\geckodriver.exe");

        // Инициализация экземпляра WebDriver для Firefox
        WebDriver driver = new FirefoxDriver();

        // Шаг 1: Переход на главную страницу сайта
        System.out.println("Шаг 1: Переход на главную страницу сайта");
        driver.get("https://testng.org/");

        // Увеличение времени ожидания до 30 секунд
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Шаг 2: Определение элементов ссылок содержания Table of Contents
        System.out.println("Шаг 2: Определение элементов ссылок содержания Table of Contents");

        // Явное ожидание появления элемента "toc" на странице
        WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toc")));

        // Дополнительное условие ожидания загрузки элементов содержания
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("a"), 0));

        // Вывод списка названий ссылок в консоль
        java.util.List<WebElement> links = content.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getText());
        }

//        try {
//            // Шаг 2.1: Нажатие на элемент содержания с использованием CSS селектора
//            WebElement linkByCss = driver.findElement(By.cssSelector("#toc a:nth-of-type(4)"));
//            linkByCss.click();
//        } catch (NoSuchElementException e) {
//            System.out.println("Элемент не найден: " + e.getMessage());
//        }
        // Шаг 2.2: Нажатие на элемент содержания с использованием XPath локатора
        WebElement linkByXPath = driver.findElement(By.xpath("//div[@id='toc']//ul//li[3]//a"));
        linkByXPath.click();

        // Закрытие браузера
        driver.quit();

    }
}
