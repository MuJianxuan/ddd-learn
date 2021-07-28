package ddd.leave.mvc.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
@Data
@Accessors(chain = true)
public class AccountDO {

    /**
     * 余额
     */
    private BigDecimal available;

    /**
     * 限额
     */
    private BigDecimal dailyLimit;

    /**
     * 货币
     */
    private String currency;

}
