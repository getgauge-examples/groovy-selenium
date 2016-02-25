package com.thoughtworks.gauge.example.pages

import org.openqa.selenium.WebElement

class SignUpPage extends BasePage {
    static String SignUpUrl = "${BASE_URL}/signup"

    WebElement user_username

    WebElement user_email

    WebElement user_password

    WebElement user_password_confirmation

    WebElement commit
}
