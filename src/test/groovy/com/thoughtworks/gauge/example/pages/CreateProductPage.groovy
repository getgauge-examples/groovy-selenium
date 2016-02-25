package com.thoughtworks.gauge.example.pages

import org.openqa.selenium.WebElement

class CreateProductPage extends BasePage {
    static String NewProductUrl = "$BASE_URL/admin/products/new/"

    WebElement product_title,
               product_description,
               product_author,
               product_price,
               commit,
               product_image_file_name

    def create(String title, String desc, String author, String price) {
        product_title.sendKeys(title)
        product_description.sendKeys(desc)
        product_author.sendKeys(author)
        product_price.sendKeys(price)
        product_image_file_name.sendKeys("not available")
        commit.click()
    }
}
