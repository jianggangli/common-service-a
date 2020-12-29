package com.entian.common.service.transaction.listener;

import com.alibaba.fastjson.JSONObject;
import com.entian.common.service.dto.CommodityOrderDTO;
import com.entian.common.service.service.OrderService;
import com.entian.common.service.service.TransactionLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianggangli
 * @version 1.0 2020/12/28 17:28
 * 功能:
 */
@Slf4j
@Component
public class OrderTransactionListener implements TransactionListener {
    @Autowired
    OrderService orderService;

    @Autowired
    TransactionLogService transactionLogService;


    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        log.info("开始执行本地事务....");
        LocalTransactionState state;
        try{
            String body = new String(message.getBody());
            CommodityOrderDTO order = JSONObject.parseObject(body, CommodityOrderDTO.class);
            orderService.createOrder(order,message.getTransactionId());
            state = LocalTransactionState.COMMIT_MESSAGE;
            log.info("本地事务已提交。{}",message.getTransactionId());
        }catch (Exception e){
            e.printStackTrace();
            log.info("执行本地事务失败。{}", e.getMessage());
            state = LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return state;
    }

    /**
     * brokerConfig.setTransactionCheckInterval(10000); //回查频率10秒一次
     * brokerConfig.setTransactionCheckMax(3);  //最大检测次数为3
     * @param messageExt
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        log.info("开始回查本地事务状态。{}",messageExt.getTransactionId());
        LocalTransactionState state;
        String transactionId = messageExt.getTransactionId();
        Map<String, Object> where = new HashMap<>();
        where.put("transaction_id", transactionId);
        if (transactionLogService.listByMap(where)!=null){
            state = LocalTransactionState.COMMIT_MESSAGE;
        }else {
            state = LocalTransactionState.UNKNOW;
        }
        log.info("结束本地事务状态查询：{}",state);
        return state;
    }
}
