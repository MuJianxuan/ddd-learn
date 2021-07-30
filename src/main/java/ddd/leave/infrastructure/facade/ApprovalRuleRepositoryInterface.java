package ddd.leave.infrastructure.facade;

import ddd.leave.domain.entity.ApprovalRule;

public interface ApprovalRuleRepositoryInterface {

    int getLeaderMaxLevel(ApprovalRule rule);
}
