package org.javaboy.alipay.controller;

import org.javaboy.alipay.bean.Orders;
import org.javaboy.alipay.bean.RespBean;
import org.javaboy.alipay.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-06-27 10:48
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public Orders getOrdersById(String id) {
        return orderService.getOrdersById(id);
    }

    @PostMapping("/")
    public RespBean addOrders(Orders orders) {
        if (orderService.addOrders(orders) == 1) {
            return RespBean.ok("OK",orders.getId());
        }
        return RespBean.error("ERROR");
    }
}
