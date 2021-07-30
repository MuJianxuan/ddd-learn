package ddd.leave.infrastructure.mapper;

import ddd.leave.infrastructure.po.LeavePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveDao extends JpaRepository<LeavePO, String> {

    List<LeavePO> queryByApplicantId(String applicantId);

    List<LeavePO> queryByApproverId(String approverId);
}
