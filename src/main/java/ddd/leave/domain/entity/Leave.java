package ddd.leave.domain.entity;

import ddd.leave.domain.valueobject.Applicant;
import ddd.leave.domain.valueobject.Approver;
import ddd.leave.domain.valueobject.LeaveType;
import ddd.leave.domain.valueobject.Status;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 请假单信息
 */
@Data
public class Leave {

    String id;
    Applicant applicant;
    Approver approver;
    LeaveType type;
    Status status;
    Date startTime;
    Date endTime;
    long duration;
    //审批领导的最大级别
    int leaderMaxLevel;
    ApprovalInfo currentApprovalInfo;
    List<ApprovalInfo> historyApprovalInfos;

    public long getDuration() {
        return endTime.getTime() - startTime.getTime();
    }

    public Leave addHistoryApprovalInfo(ApprovalInfo approvalInfo) {
        if (null == historyApprovalInfos)
            historyApprovalInfos = new ArrayList<>();
        this.historyApprovalInfos.add(approvalInfo);
        return this;
    }

    public Leave create(){
        this.setStatus(Status.APPROVING);
        this.setStartTime(new Date());
        return this;
    }

    public Leave agree(Approver nextApprover){
        this.setStatus(Status.APPROVING);
        this.setApprover(nextApprover);
        return this;
    }

    public Leave reject(Approver approver){
        this.setApprover(approver);
        this.setStatus(Status.REJECTED);
        this.setApprover(null);
        return this;
    }

    public Leave finish(){
        this.setApprover(null);
        this.setStatus(Status.APPROVED);
        this.setEndTime(new Date());
        this.setDuration(this.getEndTime().getTime() - this.getStartTime().getTime());
        return this;
    }
}
