package com.thoughtworks.gauge.example.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How

class ProductListPage extends ProductPage {
    static String ProductsUrl = Url.concat("admin/products/")

    WebElement q_title,
            commit

    @FindBy(how = How.CSS, css = "#main_content table tbody tr:nth-child(1) td.product a")
    WebElement firstProduct

    def search(String name) {
        q_title.sendKeys(name)
        commit.click()
    }

    def openFirstProduct() {
        firstProduct.click()
    }
}
