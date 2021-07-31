package ddd.leave.domain.service;

import ddd.leave.domain.entity.Account;
import ddd.leave.domain.repository.AccountRepository;
import ddd.leave.domain.repository.ExchangeRateService;
import ddd.leave.domain.valueobject.AccountExchangeRate;
import ddd.leave.domain.valueobject.Money;
import ddd.leave.domain.vo.AccountTransferVo;
import ddd.leave.mvc.mapper.AccountMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/31
 **/
@AllArgsConstructor
@Slf4j
@Service
public class AccountDomainService {

    private final AccountRepository accountRepository;
    private final ExchangeRateService exchangeRateService;
    private final AccountMapper accountMapper;

    /**
     * 分析是账户的 行为 还是 需要聚合 服务来实现转账的逻辑呢？
     *  探讨此种实现：
     *    1、由领域实体自身行为，eg；账户转money值给另外一个账户
     *    2、交给领域服务来实现   由领域服务来实现 对领域与领域之间的处理
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AccountTransferVo transfer(Long userId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {

        Money targetMoney = Money.builder().money(targetAmount).currency(targetCurrency).build();

        Account userAccount = accountRepository.getByUserId(userId);
        Account targetAccount = accountRepository.getByAccountNumber(targetAccountNumber);

        // 查询用户账户与转账金额的兑换比率
        AccountExchangeRate exchangeRate = exchangeRateService.getExchangeRate( userAccount.getCurrency(), targetMoney.getCurrency());
        targetMoney.setExchangeRate( exchangeRate);

        // 检验
        userAccount.transfer( targetAccount,targetMoney);

        // 落库
        accountMapper.decrAccountMoney( userAccount.getId(), targetMoney.getExchangeMoney() );
        accountMapper.incrAccountMoney( targetAccount.getId(),targetMoney.getExchangeMoney() );

        // TODO 发送审计消息


        return AccountTransferVo.builder().userAccount(userAccount).targetAccount( targetAccount).money( targetMoney).build();

    }

}
