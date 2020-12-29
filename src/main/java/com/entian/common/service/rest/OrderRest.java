package com.entian.common.service.rest;

import com.entian.common.service.dto.CommodityOrderDTO;
import com.entian.common.service.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianggangli
 * @version 1.0 2020/12/28 17:33
 * 功能:
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderRest {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public void createOrder(@RequestBody CommodityOrderDTO order) throws MQClientException {
        log.info("接收到订单数据：{}",order.getCommodityId());
        orderService.createOrder(order);
    }
}
