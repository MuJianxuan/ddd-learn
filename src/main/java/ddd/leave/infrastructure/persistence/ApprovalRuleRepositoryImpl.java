package ddd.leave.infrastructure.persistence;

import ddd.leave.domain.entity.ApprovalRule;
import ddd.leave.infrastructure.facade.ApprovalRuleRepositoryInterface;
import ddd.leave.infrastructure.mapper.ApprovalRuleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApprovalRuleRepositoryImpl implements ApprovalRuleRepositoryInterface {

    @Autowired
    ApprovalRuleDao ruleDao;

    @Override
    public int getLeaderMaxLevel(ApprovalRule rule) {
        String personType = rule.getPersonType();
        String leaveType = rule.getLeaveType();
        rule = ruleDao.findRule(personType, leaveType, rule.getDuration());
        return rule.getMaxLeaderLevel();
    }
}
