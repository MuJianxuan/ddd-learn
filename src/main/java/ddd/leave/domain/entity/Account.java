package ddd.leave.domain.entity;

import ddd.leave.domain.valueobject.Money;
import ddd.leave.domain.vo.AccountVo;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * Account 实体对象
 *  领域对象
 * @author Rao
 * @Date 2021/7/30
 **/
@Data
@Builder
public class Account {

    protected AccountVo accountVo;

    /**
     * 获取兑换比率
     * @return
     */
    public String getCurrency() {
        return accountVo.getCurrency();
    }


    public Long getId() {
        return accountVo.getId();
    }

    /**
     * 转钱给某账号
     * @param targetAccount
     * @param targetMoney
     */
    public void transfer(Account targetAccount, Money targetMoney) {
        BigDecimal dailyLimit = this.getAccountVo().getDailyLimit();
        Assert.isTrue( dailyLimit.compareTo( targetMoney.getExchangeMoney()) > 0,"超过今日限额！");
        BigDecimal available = this.accountVo.getAvailable();
        Assert.isTrue( available.compareTo( targetMoney.getExchangeMoney() ) > 0,"您的账户余额已不足！");
        // 减去
        accountVo.setAvailable( available.subtract( targetMoney.getExchangeMoney() ));
        // 加上
        targetAccount.getAccountVo().setAvailable( targetAccount.getAccountVo().getAvailable().multiply( targetMoney.getExchangeMoney()));

    }
}
