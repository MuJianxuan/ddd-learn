package ddd.leave.domain.repository.yahoo;

import ddd.leave.domain.valueobject.AccountExchangeRate;
import ddd.leave.domain.repository.ExchangeRateService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
@Service
public class YahooForexServiceImpl implements ExchangeRateService {

    // 注入基础设施层

    @Override
    public AccountExchangeRate getExchangeRate(@NonNull String currency, @NonNull String targetCurrency) {
        AccountExchangeRate.AccountExchangeRateBuilder accountExchangeRateBuilder = AccountExchangeRate.builder().currency(currency).targetCurrency(targetCurrency).exchangeRate(new BigDecimal("1"));
        if( ! currency.equals( targetCurrency)){
            accountExchangeRateBuilder.exchangeRate( new BigDecimal("0.6") );
        }
        return accountExchangeRateBuilder.build();
    }
}
