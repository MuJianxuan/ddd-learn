package ddd.leave.mvc.service;

import ddd.leave.mvc.common.Result;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
public interface TransferService {
    /**
     * 转账
     * @param userId
     * @param targetAccountNumber
     * @param amount
     * @param cny
     * @return
     */
    Result<Boolean> transfer(Long userId, String targetAccountNumber, BigDecimal amount, String cny);
}
