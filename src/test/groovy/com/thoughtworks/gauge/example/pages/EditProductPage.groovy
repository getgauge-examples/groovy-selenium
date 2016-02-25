package com.thoughtworks.gauge.example.pages

import org.openqa.selenium.WebElement

class EditProductPage extends ProductPage {

    static String EditProductUrl(String productId) {
        "${BASE_URL}/admin/products/${productId}/edit"
    }

    WebElement product_title,
               product_description,
               product_author,
               product_price,
               product_featured,
               product_available_on_1i,
               product_available_on_2i,
               product_available_on_3i,
               product_image_file_name,
               commit

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
