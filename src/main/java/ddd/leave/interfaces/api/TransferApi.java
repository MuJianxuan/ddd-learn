package ddd.leave.interfaces.api;

import ddd.leave.application.service.TransferApplicationService;
import ddd.leave.interfaces.dto.TransferDto;
import ddd.leave.mvc.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * DDD 改造
 * @author Rao
 * @Date 2021/7/28
 **/
@RestController
@RequestMapping("/ddd/transfer")
public class TransferApi {

    private TransferApplicationService transferApplicationService;

    /**
     * 概念描述： 账户转账
     * @param transferDto
     * @param session
     * @return
     */
    @PostMapping
    public Result<Boolean> transfer(TransferDto transferDto, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return transferApplicationService.transfer(userId, transferDto.getTargetAccountNumber(), transferDto.getAmount(), "CNY");
    }

}
