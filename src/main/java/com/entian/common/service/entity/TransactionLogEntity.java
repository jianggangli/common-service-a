package com.entian.common.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.entian.common.service.mybatis.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jianggangli
 * @version 1.0 2020/12/28 17:50
 * 功能:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("transaction_log")
public class TransactionLogEntity extends BaseEntity {

    /**
     * 业务标识
     */
    private String business;
    /**
     * 对应业务表中的主键
     */
    private String foreignKey;

    /**
     * mq记录id
     */
    private String transactionId;
}
