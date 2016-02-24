package com.thoughtworks.gauge.example.pages

import org.openqa.selenium.WebElement

class CreateProductPage extends BasePage {
    static String NewProductUrl = Url.concat("admin/products/new/")

    WebElement product_title

    WebElement product_description

    WebElement product_author

    WebElement product_price

    WebElement commit

    WebElement product_image_file_name

    def create(String title, String desc, String author, String price) {
        product_title.sendKeys(title)
        product_description.sendKeys(desc)
        product_author.sendKeys(author)
        product_price.sendKeys(price)
        product_image_file_name.sendKeys("not available")
        commit.click()
    }
}
