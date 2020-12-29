package com.entian.common.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entian.common.service.entity.TransactionLogEntity;
import com.entian.common.service.mapper.TransactionLogMapper;
import com.entian.common.service.service.TransactionLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author jianggangli
 * @version 1.0 2020/12/29 15:03
 * 功能:
 */
@Slf4j
@Service
public class TransactionLogServiceImpl extends ServiceImpl<TransactionLogMapper, TransactionLogEntity> implements
        TransactionLogService {
}
