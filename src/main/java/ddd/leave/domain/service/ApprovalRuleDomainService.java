package ddd.leave.domain.service;

import ddd.leave.domain.entity.ApprovalRule;
import ddd.leave.domain.repository.ApprovalRuleRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalRuleDomainService {

    @Autowired
    ApprovalRuleRepositoryInterface repositoryInterface;

    public int getLeaderMaxLevel(String personType, String leaveType, long duration) {
        ApprovalRule rule = new ApprovalRule();
        rule.setPersonType(personType);
        rule.setLeaveType(leaveType);
        rule.setDuration(duration);
        return repositoryInterface.getLeaderMaxLevel(rule);
    }
}
