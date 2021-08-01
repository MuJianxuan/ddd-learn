package ddd.leave.application.service;

import ddd.leave.domain.service.AccountDomainService;
import ddd.leave.domain.vo.AccountTransferVo;
import ddd.leave.mvc.common.Result;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 应用服务 聚合 领域服务、编排业务流程等功能
 * 编排业务流程 需要把控 业务粒度
 *   转账和 发对账消息是同一个事情吗 ？ 业务属于同一个范畴吗
 * @author Rao
 * @Date 2021/7/30
 **/
@AllArgsConstructor
@Service
public class TransferApplicationService {

    private final AccountDomainService accountDomainService;

    /**
     * 1、从MySql数据库中找到转出和转入的账户，选择用 MyBatis 的 mapper 实现 DAO；
     * 2、从 Yahoo（或其他渠道）提供的汇率服务获取转账的汇率信息（底层是 http 开放接口）；
     * 3、计算需要转出的金额，确保账户有足够余额，并且没超出每日转账上限；
     * 4、实现转入和转出操作，扣除手续费，保存数据库；
     * 5、发送 Kafka 审计消息，以便审计和对账用；
     * @param userId
     * @param targetAccountNumber
     * @param targetAmount
     * @param targetCurrency 货币类型
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> transfer(Long userId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {

        // 转账
        accountDomainService.transfer(userId, targetAccountNumber, targetAmount, targetCurrency);

        return Result.success( Boolean.TRUE);
    }
}
