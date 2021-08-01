package ddd.leave.interfaces.api;

import ddd.leave.application.service.TransferApplicationService;
import ddd.leave.interfaces.dto.TransferDto;
import ddd.leave.mvc.common.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * DDD 改造
 * @author Rao
 * @Date 2021/7/28
 **/
@AllArgsConstructor
@RestController
@RequestMapping("/ddd/transfer")
public class AccountTransferApi {

    /**
     * 这里我在思考
     *   是否需要引入 领域服务层呢？
     *   转账这个业务 是否仅仅需要 领域服务即可完成 ，而不需要中间人来操作
     *
     *   如果application service层 有什么好处 数据结果的转换多了一层包装， 这样数据的结果不依赖 领域服务的返回
     */
    private final TransferApplicationService transferApplicationService;

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
