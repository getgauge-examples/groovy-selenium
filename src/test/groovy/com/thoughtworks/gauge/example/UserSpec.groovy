package com.thoughtworks.gauge.example

import com.thoughtworks.gauge.Step
import com.thoughtworks.gauge.example.pages.SignUpPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class UserSpec {
    private final WebDriver driver

    public UserSpec() {
        this.driver = DriverFactory.getDriver()
    }

    String localPart() {
        // Creating a random local part of an email address also used as username
        return UUID.randomUUID().toString()
    }

    @Step("On signup page")
    def navigateToSignUpPage() {
        driver.get(SignUpPage.SignUpUrl)
    }

    @Step("Fill in and send registration form")
    def searchUser() {
        String username = localPart()
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage)
        signUpPage.user_username.sendKeys(username)
        signUpPage.user_email.sendKeys(username.concat("@domain.com"))
        signUpPage.user_password.sendKeys("qweqwe")
        signUpPage.user_password_confirmation.sendKeys("qweqwe")
        signUpPage.commit.submit()
        // store generated username
        signUpPage.storeStringToScenarioDataStore("currentUser", username)
    }
}
