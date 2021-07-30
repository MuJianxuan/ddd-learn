package ddd.leave.application.service;

import ddd.leave.mvc.common.Result;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 应用服务 聚合 领域服务、编排业务流程等功能
 * @author Rao
 * @Date 2021/7/30
 **/
@Service
public class TransferApplicationService {

    /**
     * 转账接口
     * @param userId
     * @param targetAccountNumber
     * @param amount
     * @param cny
     * @return
     */
    public Result<Boolean> transfer(Long userId, String targetAccountNumber, BigDecimal amount, String cny) {



        return null;
    }
}
