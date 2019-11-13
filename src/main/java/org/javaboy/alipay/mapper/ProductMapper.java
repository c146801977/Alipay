package org.javaboy.alipay.mapper;

import org.javaboy.alipay.bean.Product;

import java.util.List;

public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);

    List<Product> getAllProduct();

    Product getProductById(String productId);
}