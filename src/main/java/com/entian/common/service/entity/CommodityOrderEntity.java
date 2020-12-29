package com.entian.common.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.entian.common.service.mybatis.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author jianggangli
 * @version 1.0 2020/12/28 17:54
 * 功能:
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("commodity_order")
public class CommodityOrderEntity extends BaseEntity {
    private String commodityId;
    private String orderNo;
}
