package ddd.leave.infrastructure.db.mapper;


import ddd.leave.infrastructure.db.po.AccountPO;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
public interface AccountDao {

    default AccountPO selectByAccountNumber(String targetAccountNumber) {
        return new AccountPO().setAvailable(new BigDecimal("100")).setDailyLimit(new BigDecimal("1000")).setCurrency("CNY");
    }

    default AccountPO selectByUserId(Long userId) {
        return new AccountPO().setAvailable(new BigDecimal("10000")).setDailyLimit(new BigDecimal("1000")).setCurrency("CNY");
    }

    void update(AccountPO sourceAccountDO);
}
