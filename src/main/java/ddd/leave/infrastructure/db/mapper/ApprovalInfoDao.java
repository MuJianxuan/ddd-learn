package ddd.leave.infrastructure.db.mapper;

import ddd.leave.infrastructure.db.po.ApprovalInfoPO;
import ddd.leave.infrastructure.db.po.LeavePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalInfoDao extends JpaRepository<ApprovalInfoPO, String> {

    List<LeavePO> queryByApplicantId(String applicantId);

    List<ApprovalInfoPO> queryByLeaveId(String leaveId);

}
