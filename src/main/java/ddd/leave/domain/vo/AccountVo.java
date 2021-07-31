package ddd.leave.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
@Data
public class AccountVo {

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
