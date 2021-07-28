package ddd.leave.mvc.mapper;

import ddd.leave.mvc.entity.AccountDO;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
public interface AccountMapper {

    AccountDO selectByAccountNumber(String targetAccountNumber);

    AccountDO selectByUserId(Long userId);
}
