package com.thoughtworks.gauge.example

import com.thoughtworks.gauge.AfterSuite
import com.thoughtworks.gauge.BeforeSuite
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

class DriverFactory {
    private static final String FIREFOX = "firefox"

    static WebDriver driver

    @BeforeSuite
    def Setup() {
        def browser = System.getenv("browser.name")
        if (browser.toLowerCase().equals(FIREFOX)) {
            driver = new FirefoxDriver()
        } else {
            driver = new ChromeDriver()
        }
    }

    @AfterSuite
    def TearDown() {
        driver.close()
    }
}
