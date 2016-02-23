package com.thoughtworks.gauge.example
import com.thoughtworks.gauge.Step
import com.thoughtworks.gauge.Table
import com.thoughtworks.gauge.TableRow
import com.thoughtworks.gauge.example.pages.CustomerPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

public class CustomerSpec {
    private final WebDriver driver

    public CustomerSpec() {
        this.driver = DriverFactory.getDriver()
    }

    @Step("On the customer page")
    def navigateToCustomersPage() {
        driver.get(CustomerPage.CustomerUrl)
    }

    @Step("Search for customer <name>")
    def searchUser(String username) {
        CustomerPage customerPage = PageFactory.initElements(driver, CustomerPage.class)
        customerPage.searchUser(username)
    }

    @Step("The customer <name> is listed")
    def verifyUserIsListed(String username) {
        CustomerPage customerPage = PageFactory.initElements(driver, CustomerPage.class)
        customerPage.verifyUserListed(username)
    }

    @Step("Search for customers <table>")
    def verifyCustomers(Table table) {
        List<TableRow> rows = table.getTableRows()
        List<String> columnNames = table.getColumnNames()
        for (TableRow row : rows) {
            searchUser(row.getCell(columnNames.get(0)))
            verifyUserIsListed(row.getCell(columnNames.get(0)))
        }
    }

    @Step("Just registered customer is listed")
    def verifyJustRegisteredCustomerListed() {
        CustomerPage customerPage = PageFactory.initElements(driver, CustomerPage.class)
        String currentUser = customerPage.fetchStringFromScenarioDataStore("currentUser")
        verifyUserIsListed(currentUser)
    }
}
