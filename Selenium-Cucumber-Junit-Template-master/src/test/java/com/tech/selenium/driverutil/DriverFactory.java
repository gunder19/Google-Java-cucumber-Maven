package com.tech.selenium.driverutil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver _driver;
    public static WebDriver getBrowser(String _browserName) {

        DriverType _driverType = DriverType.valueOf(_browserName);

        try {
            switch (_driverType) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    _driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    _driver = new FirefoxDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    _driver = new EdgeDriver();
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    _driver = new InternetExplorerDriver();
                    break;
                case OPERA:
                    WebDriverManager.operadriver().setup();
                    _driver = new OperaDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    _driver = new ChromeDriver();
                    break;
            }
        } catch (Exception e) {
            Assert.fail("Driver is not supported on your PC or not supported version");
        }
        _driver.manage().window().maximize();
        _driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return _driver;
    }
}