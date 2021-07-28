package ddd.leave.mvc.service.impl;

import ddd.leave.mvc.service.YahooForexService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
@Service
public class YahooForexServiceImpl implements YahooForexService {
    @Override
    public BigDecimal getExchangeRate(String currency, String targetCurrency) {
        return new BigDecimal("0.02");
    }
}
