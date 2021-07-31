package ddd.leave.mvc.mapper;

import ddd.leave.mvc.entity.AccountDO;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
public interface AccountMapper {

    default AccountDO selectByAccountNumber(String targetAccountNumber) {
        return new AccountDO().setAvailable(new BigDecimal("100")).setDailyLimit(new BigDecimal("1000")).setCurrency("CNY");
    }

    default AccountDO selectByUserId(Long userId) {
        return new AccountDO().setAvailable(new BigDecimal("10000")).setDailyLimit(new BigDecimal("1000")).setCurrency("CNY");
    }

    void update(AccountDO sourceAccountDO);

    void decrAccountMoney(Long id, BigDecimal money);

    void incrAccountMoney(Long id, BigDecimal money);
}
