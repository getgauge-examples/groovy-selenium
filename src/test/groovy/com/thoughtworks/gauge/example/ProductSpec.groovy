package com.thoughtworks.gauge.example

import com.thoughtworks.gauge.Step
import com.thoughtworks.gauge.Table
import com.thoughtworks.gauge.TableRow
import com.thoughtworks.gauge.example.pages.CreateProductPage
import com.thoughtworks.gauge.example.pages.EditProductPage
import com.thoughtworks.gauge.example.pages.ProductListPage
import com.thoughtworks.gauge.example.pages.ProductPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

public class ProductSpec {
    private final WebDriver driver

    public ProductSpec() {
        this.driver=DriverFactory.getDriver()
    }

    @Step("Create a product <table>")
    def CreateProduct(Table table) {
        List<TableRow> rows = table.getTableRows()
        List<String> columnNames = table.getColumnNames()
        rows.each { row ->
            openNewProductsPage()
            CreateProductPage createProductPage = PageFactory.initElements(driver, CreateProductPage.class)
            createProductPage.create(row.getCell(columnNames.get(0)),row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)))
        }
    }

    @Step("On product page")
    def openProductsPage() {
        driver.get(ProductListPage.ProductsUrl)
    }

    @Step("Search for product <name>")
    def searchProduct(String title) {
        ProductListPage productListPage = PageFactory.initElements(driver, ProductListPage.class)
        productListPage.search(title)
    }
    @Step("Open description for product <name>")
    def viewProductDescription(String name) {
        ProductListPage productListPage = PageFactory.initElements(driver, ProductListPage.class)
        productListPage.openFirstProduct()
    }

    @Step("Verify product <specifier> as <value>")
    def verifyProduct(String specifier, String value) {
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class)
        productPage.verifyProductSpecifier(productPage.getWebElementByName(specifier), value)
    }

    @Step("Delete this product")
    def deleteProduct() {
        PageFactory.initElements(driver, ProductPage.class).delete(driver)
    }

    @Step("On new products page")
    def openNewProductsPage() {
        driver.get(CreateProductPage.NewProductUrl)
    }

    @Step("Open product edit page for stored productId")
    def openProductEditPage() {
        def editProductPage = PageFactory.initElements(driver, EditProductPage.class)
        driver.get(EditProductPage.EditProductUrl(editProductPage.fetchStringFromScenarioDataStore("productId")))
    }

    @Step("Update product specifier to new value <table>")
    def updateProductValue(Table table) {
        List<TableRow> rows = table.getTableRows()
        List<String> columnNames = table.getColumnNames()
        rows.each { row ->
            openProductEditPage()
            EditProductPage editProductPage = PageFactory.initElements(driver, EditProductPage.class)
            editProductPage.updateProductValue(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)))
        }
    }

    @Step("Check product specifier has new value <table>")
    def verifyProductValue(Table table) {
        List<TableRow> rows = table.getTableRows()
        List<String> columnNames = table.getColumnNames()
        rows.each { row ->
            def productPage = PageFactory.initElements(driver, ProductPage.class)
            WebElement specifier = productPage.getWebElementByName((row.getCell(columnNames.get(0))))
            productPage.verifyProductSpecifier(specifier, row.getCell(columnNames.get(1)))
        }
    }
}
