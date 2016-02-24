package com.thoughtworks.gauge.example

import com.thoughtworks.gauge.AfterSuite
import com.thoughtworks.gauge.BeforeScenario
import com.thoughtworks.gauge.Table
import com.thoughtworks.gauge.example.pages.ProductListPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class ExecutionHooks {

    private final WebDriver driver
    private Table table

    public ExecutionHooks() {
        this.driver=DriverFactory.getDriver()
    }

    @BeforeScenario(tags = ["edit"])
    def findAndStoreProductId() {
        driver.get(ProductListPage.ProductsUrl)
        def productListPage = PageFactory.initElements(driver, ProductListPage)
        productListPage.search("The Way to Go")
        productListPage.openFirstProduct()
        productListPage.storeStringToScenarioDataStore("productId", productListPage.productId.text)
    }

    @AfterSuite
    def deleteTestProducts() {

    }
}
