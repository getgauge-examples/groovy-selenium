package com.thoughtworks.gauge.example
import com.thoughtworks.gauge.Step
import com.thoughtworks.gauge.Table
import com.thoughtworks.gauge.TableRow
import com.thoughtworks.gauge.example.pages.CustomerPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class CustomerSpec {
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
        def customerPage = PageFactory.initElements(driver, CustomerPage)
        customerPage.searchUser(username)
    }

    @Step("The customer <name> is listed")
    def verifyUserIsListed(String username) {
        def customerPage = PageFactory.initElements(driver, CustomerPage)
        customerPage.verifyUserListed(username)
    }

    @Step("Search for customers <table>")
    def verifyCustomers(Table table) {
        List<TableRow> rows = table.tableRows
        List<String> columnNames = table.columnNames
        rows.each { row ->
            searchUser(row.getCell(columnNames[0]))
            verifyUserIsListed(row.getCell(columnNames[0]))
        }
    }

    @Step("Just registered customer is listed")
    def verifyJustRegisteredCustomerListed() {
        def customerPage = PageFactory.initElements(driver, CustomerPage)
        def currentUser = customerPage.fetchStringFromScenarioDataStore("currentUser")
        verifyUserIsListed(currentUser)
    }
}
