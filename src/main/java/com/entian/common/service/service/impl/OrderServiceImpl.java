package com.entian.common.service.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entian.common.service.dto.CommodityOrderDTO;
import com.entian.common.service.entity.CommodityOrderEntity;
import com.entian.common.service.entity.TransactionLogEntity;
import com.entian.common.service.mapper.CommodityOrderMapper;
import com.entian.common.service.mapper.TransactionLogMapper;
import com.entian.common.service.service.OrderService;
import com.entian.common.service.transaction.TransactionProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jianggangli
 * @version 1.0 2020/12/28 17:31
 * 功能:
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<CommodityOrderMapper, CommodityOrderEntity> implements OrderService   {
    @Autowired
    CommodityOrderMapper commodityOrderMapper;
    @Autowired
    TransactionLogMapper transactionLogMapper;
    @Autowired
    TransactionProducer producer;

    Snowflake snowflake = new Snowflake(1,1);

    /**
     * 执行本地事务时调用，将订单数据和事务日志写入本地数据库
     *
     * @param commodityOrderDTO
     * @param transactionId
     */
    @Transactional
    @Override
    public void createOrder(CommodityOrderDTO commodityOrderDTO, String transactionId) {

        /**
         * 创建订单
         */
        CommodityOrderEntity order = new CommodityOrderEntity();
        BeanUtils.copyProperties(commodityOrderDTO, order);
        commodityOrderMapper.insert(order);

        /**
         * 写入事务日志
         */
        TransactionLogEntity transactionLog = new TransactionLogEntity();
        transactionLog.setTransactionId(transactionId);
        transactionLog.setBusiness("order");
        transactionLog.setForeignKey(order.getId());
        transactionLogMapper.insert(transactionLog);

        log.info("订单创建完成。{}", commodityOrderDTO);
    }


    /**
     * 前端调用，只用于向RocketMQ发送事务消息
     * @param order
     * @throws MQClientException
     */
    @Override
    public void createOrder(CommodityOrderDTO order) throws MQClientException {
        order.setOrderNo(snowflake.nextIdStr());
        producer.send(JSON.toJSONString(order),"order");
    }
}
