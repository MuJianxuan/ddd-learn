package ddd.leave.domain.repository;

import ddd.leave.domain.entity.Account;

import java.io.Serializable;

/**
 * @author Rao
 * @Date 2021/7/31
 **/
public interface AccountRepository {

    Account getByUserId(Serializable id);

    Account getByAccountNumber(String targetAccountNumber);
}
