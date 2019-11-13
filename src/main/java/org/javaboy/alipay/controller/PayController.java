package org.javaboy.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import org.javaboy.alipay.bean.Orders;
import org.javaboy.alipay.bean.Product;
import org.javaboy.alipay.bean.RespBean;
import org.javaboy.alipay.commons.AlipayConfig;
import org.javaboy.alipay.service.OrderService;
import org.javaboy.alipay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-06-27 11:42
 */
@RestController
@RequestMapping("/alipay")
public class PayController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    @GetMapping("/alipayReturnNotice")
    public void alipayReturnNotice(HttpServletRequest req) {
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + ">>>>>>" + req.getParameter(name));
        }

        // 获取支付宝GET过来反馈信息
        try {
            Map<String, String> params = new HashMap<String, String>();
            Map<String, String[]> requestParams = req.getParameterMap();
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                // 乱码解决，这段代码在出现乱码时使用
                System.out.println(">>>>>>>>>" + valueStr);
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }

            //根据支付宝返回的信息校验是否支付成功
            boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
                    AlipayConfig.sign_type); // 调用SDK验证签名

            //成功返回页面

            // 验证是否成功
            if (signVerified) {// 验证成功
                // 商户订单号
                String out_trade_no = new String(req.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

                // 支付宝交易号
                String trade_no = new String(req.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

                // 交易状态
                String total_amount = new String(req.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

                // 进行业务操作，更新订单状态，并且更新商品库存

            } else {// 验证失败
                System.out.println("验证失败...");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

    }

    @PostMapping(value = "/", produces = "text/html; charset=UTF-8")
    public String pay(String oid) {
        Orders orders = orderService.getOrdersById(oid);
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);

        // 设置请求参数
//        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
//        request.setReturnUrl(AlipayConfig.return_url);
//        request.setNotifyUrl(AlipayConfig.notify_url);
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        request.setReturnUrl(AlipayConfig.return_url);
        request.setNotifyUrl(AlipayConfig.notify_url);

        Product product = productService.getProductById(orders.getProductId());
        // 商户订单号，商户网站订单系统中唯一订单号，必填(随机生成)
        String out_trade_no = orders.getId();
        // 付款金额
        String total_amount = orders.getOrderAmount();
        // 订单名称，必填
        String subject = product.getName();
        // 商品描述，可空
        String body = "购买数量：" + orders.getBuyCounts();

        // 自定义超时时间参数timeout_express
        String timeout_express = "1c";

        request.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
                + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\"," + "\"timeout_express\":\""
                + timeout_express + "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        // 请求
        String result = null;
        try {
            result = alipayClient.pageExecute(request).getBody();
            System.out.println(result);
            return result;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return ">>>>";
    }
}
