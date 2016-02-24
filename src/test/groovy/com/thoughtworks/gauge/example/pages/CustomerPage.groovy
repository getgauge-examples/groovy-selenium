package com.thoughtworks.gauge.example.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How

class CustomerPage extends BasePage {
    static String CustomerUrl = Url.concat("admin/customers/")

    WebElement q_username,
            commit

    @FindBy(how = How.CSS, css = "table#index_table_customers tbody tr:nth-child(1) td.col-username")
    WebElement usernameResult

    def searchUser(String username) {
        q_username.clear()
        q_username.sendKeys(username)
        commit.click()
    }

    def verifyUserListed(String username) {
        assert username.equals(usernameResult.getText())
    }
}
