package ddd.leave.infrastructure.po;

import ddd.leave.domain.entity.Leave;
import ddd.leave.domain.valueobject.LeaveType;
import ddd.leave.domain.valueobject.Status;
import ddd.leave.domain.valueobject.PersonType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Leave")
@Data
public class LeavePO {

    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
    String id;
    String applicantId;
    String applicantName;
    @Enumerated(EnumType.STRING)
    PersonType applicantType;
    String approverId;
    String approverName;
    @Enumerated(EnumType.STRING)
    LeaveType leaveType;
    @Enumerated(EnumType.STRING)
    Status status;
    Date startTime;
    Date endTime;
    long duration;
    @Transient
    List<ApprovalInfoPO> historyApprovalInfoPOList;

    public Leave toLeave() {
        return new Leave();
    }

}
