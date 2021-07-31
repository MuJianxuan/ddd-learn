package ddd.leave.domain.valueobject;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 账户兑换比率
 * @author Rao
 * @Date 2021/7/31
 **/
@Data
@Builder
public class AccountExchangeRate {

    private String currency;
    private String targetCurrency;
    private BigDecimal exchangeRate;

}
