package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTestngOrg {
    private WebDriver firefoxDriver;
    private WebDriver chromeDriver;

    @BeforeClass
    public void setUp() {
        // Установка пути к geckodriver.exe для Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Пётр\\OneDrive\\Рабочий стол\\4 семестр\\Информационка\\Lab5\\SeleniumAndWebDriver\\GeckoDriver\\geckodriver.exe");
        // Инициализация экземпляра WebDriver для Firefox
        firefoxDriver = new FirefoxDriver();

        // Установка пути к chromedriver.exe для Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Пётр\\OneDrive\\Рабочий стол\\4 семестр\\Информационка\\Lab5\\SeleniumAndWebDriver\\ChromeDriver\\chromedriver.exe");
        // Инициализация экземпляра WebDriver для Chrome
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void testNavigationFirefox() {
        // Шаг 1: Переход на главную страницу сайта
        System.out.println("Шаг 1 (Firefox): Переход на главную страницу сайта");
        firefoxDriver.get("https://testng.org/");

        // Увеличение времени ожидания до 30 секунд
        WebDriverWait wait = new WebDriverWait(firefoxDriver, 20);

        // Шаг 2: Определение элементов ссылок содержания Table of Contents
        System.out.println("Шаг 2 (Firefox): Определение элементов ссылок содержания Table of Contents");

        // Явное ожидание появления элемента "toc" на странице
        WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toc")));

        // Дополнительное условие ожидания загрузки элементов содержания
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("a"), 0));

        // Вывод списка названий ссылок в консоль
        java.util.List<WebElement> links = content.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getAttribute("textContent"));
        }

        // Шаг 2.2: Нажатие на элемент содержания с использованием XPath локатора
        WebElement linkByXPath = firefoxDriver.findElement(By.xpath("//div[@id='toc']//ul//li[3]//a"));
        linkByXPath.click();
    }

    @Test
    public void testNavigationChrome() {
        // Шаг 1: Переход на главную страницу сайта
        System.out.println("Шаг 1 (Chrome): Переход на главную страницу сайта");
        chromeDriver.get("https://testng.org/");

        // Увеличение времени ожидания до 30 секунд
        WebDriverWait wait = new WebDriverWait(chromeDriver, 20);

        // Шаг 2: Определение элементов ссылок содержания Table of Contents
        System.out.println("Шаг 2 (Chrome): Определение элементов ссылок содержания Table of Contents");

        // Явное ожидание появления элемента "toc" на странице
        WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toc")));

        // Дополнительное условие ожидания загрузки элементов содержания
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("a"), 0));

        // Вывод списка названий ссылок в консоль
        java.util.List<WebElement> links = content.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getAttribute("textContent"));
        }

        // Шаг 2.2: Нажатие на элемент содержания с использованием XPath локатора
        WebElement linkByXPath = chromeDriver.findElement(By.xpath("//div[@id='toc']//ul//li[3]//a"));
        linkByXPath.click();
    }

    @AfterClass
    public void tearDown() {
        // Закрытие браузеров
        if (firefoxDriver != null) {
            firefoxDriver.quit();
        }
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }
}
