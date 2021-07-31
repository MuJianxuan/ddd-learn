package ddd.leave.domain.valueobject;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
@Data
@Builder
public class Money {

    /**
     * 金钱
     */
    private BigDecimal money;

    /**
     * 汇率转换问题
     */
    private String currency;

    private AccountExchangeRate exchangeRate;

    /**
     * 获取转换后的 钱
     * @return
     */
    public BigDecimal getExchangeMoney() {
        return  money.multiply( exchangeRate.getExchangeRate() );
    }
}
