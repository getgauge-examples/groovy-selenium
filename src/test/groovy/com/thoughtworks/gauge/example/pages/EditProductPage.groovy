package com.thoughtworks.gauge.example.pages

import org.openqa.selenium.WebElement

class EditProductPage extends ProductPage {

    static String EditProductUrl(String productId) {
        return Url.concat("admin/products/" + productId + "/edit")
    }

    WebElement product_title

    WebElement product_description

    WebElement product_author

    WebElement product_price

    WebElement product_featured

    WebElement product_available_on_1i

    WebElement product_available_on_2i

    WebElement product_available_on_3i

    WebElement product_image_file_name

    WebElement commit

    void saveProduct() {
        commit.click()
    }

    void updateProductValue(String specifier, String newValue) {
        switch (specifier.toLowerCase()) {
            case "title":
                product_title.clear()
                product_title.sendKeys(newValue)
                break
            case "description":
                product_description.clear()
                product_description.sendKeys(newValue)
                break
            case "author":
                product_author.clear()
                product_author.sendKeys(newValue)
                break
            case "price":
                product_price.clear()
                product_price.sendKeys(newValue)
                break
            case "imageFileName":
                product_image_file_name.clear()
                product_image_file_name.sendKeys(newValue)
                break
        }
        saveProduct()
    }
}
