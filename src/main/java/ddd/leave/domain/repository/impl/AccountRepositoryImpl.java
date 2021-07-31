package ddd.leave.domain.repository.impl;

import ddd.leave.domain.entity.Account;
import ddd.leave.domain.repository.AccountRepository;
import ddd.leave.domain.vo.AccountVo;
import ddd.leave.infrastructure.db.mapper.AccountDao;
import ddd.leave.infrastructure.db.po.AccountPO;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author Rao
 * @Date 2021/7/31
 **/
@Slf4j
@Service
public class AccountRepositoryImpl implements AccountRepository {

    @Mock
    @Resource
    private AccountDao accountDao;

    private AccountVo poToVo( AccountPO accountPo){
        AccountVo accountVo = new AccountVo();
        BeanUtils.copyProperties(accountPo,accountVo );
        return accountVo;
    }

    @Override
    public Account getByUserId(Serializable id) {
        AccountPO accountPo = accountDao.selectByUserId(Long.parseLong(id.toString()));

        return Account.builder().accountVo( poToVo( accountPo)).build();
    }

    @Override
    public Account getByAccountNumber(String targetAccountNumber) {
        AccountPO accountPo = accountDao.selectByAccountNumber(targetAccountNumber);
        return Account.builder().accountVo( poToVo( accountPo)).build();
    }
}
