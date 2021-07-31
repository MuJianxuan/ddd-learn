package ddd.leave.domain.repository;

import ddd.leave.domain.valueobject.AccountExchangeRate;

/**
 * @author Rao
 * @Date 2021/7/31
 **/
public interface ExchangeRateService {

    /**
     * 查询兑换比率
     * @param currency
     * @param targetCurrency
     * @return
     */
    AccountExchangeRate getExchangeRate(String currency, String targetCurrency);
}
