package org.javaboy.alipay.controller;

import org.javaboy.alipay.bean.Product;
import org.javaboy.alipay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-06-27 10:28
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }
}
