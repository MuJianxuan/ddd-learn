package ddd.leave.interfaces.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/30
 **/
@Data
public class TransferDto implements Serializable {

    private String targetAccountNumber;
    private BigDecimal amount ;

    private Long userId;

}
