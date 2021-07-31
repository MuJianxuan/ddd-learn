package ddd.leave.infrastructure.db.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
@Data
@Accessors(chain = true)
public class AccountPO {

    private Long id;
    /**
     * 余额
     */
    private BigDecimal available;

    /**
     * 限额
     */
    private BigDecimal dailyLimit;

    /**
     * 货币  USD / CNY
     */
    private String currency;

}
