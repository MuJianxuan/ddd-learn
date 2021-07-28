package ddd.leave.mvc.service;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
public interface YahooForexService {
    /**
     * 获取转换汇率
     * @param currency
     * @param targetCurrency
     * @return
     */
    BigDecimal getExchangeRate(String currency, String targetCurrency);
}
