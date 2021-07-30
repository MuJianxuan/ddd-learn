package ddd.leave.domain.rule.repository.facade;

import ddd.leave.domain.entity.ApprovalRule;

public interface ApprovalRuleRepositoryInterface {

    int getLeaderMaxLevel(ApprovalRule rule);
}
