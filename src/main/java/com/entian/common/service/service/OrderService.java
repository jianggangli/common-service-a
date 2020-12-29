package com.entian.common.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entian.common.service.dto.CommodityOrderDTO;
import com.entian.common.service.entity.CommodityOrderEntity;
import org.apache.rocketmq.client.exception.MQClientException;

/**
 * @author jianggangli
 * @version 1.0 2020/12/28 17:31
 * 功能:
 */
public interface OrderService extends IService<CommodityOrderEntity> {

    /**
     * 执行本地事务时调用，将订单数据和事务日志写入本地数据库
     */
    public void createOrder(CommodityOrderDTO commodityOrderDTO, String transactionId);

    /**
     * 前端调用，只用于向RocketMQ发送事务消息
     * @param order
     * @throws MQClientException
     */
    public void createOrder(CommodityOrderDTO order) throws MQClientException;
}
