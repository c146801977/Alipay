package org.javaboy.alipay.service;

import org.javaboy.alipay.bean.Orders;
import org.javaboy.alipay.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-06-27 10:50
 */
@Service
public class OrderService {
    @Autowired
    OrdersMapper ordersMapper;
    public Integer addOrders(Orders orders) {
        orders.setCreateTime(new Date());
        orders.setOrderStatus("10");
        orders.setId(UUID.randomUUID().toString());
        orders.setOrderNum(UUID.randomUUID().toString());
        return ordersMapper.insertSelective(orders);
    }

    public Orders getOrdersById(String id) {
        return ordersMapper.getOrdersById(id);
    }
}
