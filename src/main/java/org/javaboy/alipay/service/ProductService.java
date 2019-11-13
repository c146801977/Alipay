package org.javaboy.alipay.service;

import org.javaboy.alipay.bean.Product;
import org.javaboy.alipay.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-06-27 10:29
 */
@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }

    public Product getProductById(String productId) {
        return productMapper.getProductById(productId);
    }
}
