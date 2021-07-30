package ddd.leave.domain.entity;

import ddd.leave.domain.valueobject.ApprovalType;
import ddd.leave.domain.valueobject.Approver;
import lombok.Data;

@Data
public class ApprovalInfo {

    String approvalInfoId;
    Approver approver;
    ApprovalType approvalType;
    String msg;
    long time;

}
