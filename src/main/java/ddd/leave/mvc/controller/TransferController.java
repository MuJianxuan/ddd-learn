package ddd.leave.mvc.controller;

import ddd.leave.mvc.common.Result;
import ddd.leave.mvc.service.TransferService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
@RestController
@RequestMapping("/transfer")
public class TransferController {

    private TransferService transferService;

    public Result<Boolean> transfer(String targetAccountNumber, BigDecimal amount, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return transferService.transfer(userId, targetAccountNumber, amount, "CNY");
    }

}
