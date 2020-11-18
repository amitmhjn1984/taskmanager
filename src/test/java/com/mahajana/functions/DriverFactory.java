package com.mahajana.functions;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class DriverFactory {
    protected static WebDriver driver;
    private final EnvironmentContext environmentContext = new EnvironmentContext();

    public DriverFactory() {
        initialize();
    }

    public void initialize() {
        if (driver == null) {
            createNewDriverInstance();
        }
    }

    private void createNewDriverInstance() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (environmentContext.hasProperty("chrome.parameters")) {
            String chromeProperty = environmentContext.getProperty("chrome.parameters");
            chromeOptions.addArguments(Lists.newArrayList(chromeProperty.split(",")));
        }
        System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver_win32_1\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destoryDriver() {
        driver.quit();
        driver = null;
    }

 }
