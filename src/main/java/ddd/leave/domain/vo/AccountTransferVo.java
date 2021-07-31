package ddd.leave.domain.vo;

import ddd.leave.domain.entity.Account;
import ddd.leave.domain.valueobject.Money;
import lombok.Builder;
import lombok.Data;

/**
 * @author Rao
 * @Date 2021/8/1
 **/
@Data
@Builder
public class AccountTransferVo {

    private Account userAccount;

    private Account targetAccount;

    private Money money;

}
