package ddd.leave.domain.leave.repository.persistence;

import ddd.leave.domain.leave.repository.facade.LeaveRepositoryInterface;
import ddd.leave.infrastructure.mapper.ApprovalInfoDao;
import ddd.leave.infrastructure.mapper.LeaveDao;
import ddd.leave.infrastructure.mapper.LeaveEventDao;
import ddd.leave.infrastructure.po.ApprovalInfoPO;
import ddd.leave.infrastructure.po.LeaveEventPO;
import ddd.leave.infrastructure.po.LeavePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * persist entity and handle event in repository
 */
@Repository
public class LeaveRepositoryImpl implements LeaveRepositoryInterface {

    @Autowired
    LeaveDao leaveDao;
    @Autowired
    ApprovalInfoDao approvalInfoDao;
    @Autowired
    LeaveEventDao leaveEventDao;

    public void save(LeavePO leavePO) {
        //persist leave entity
        leaveDao.save(leavePO);
       //set leave_id for approvalInfoPO after save leavePO
        leavePO.getHistoryApprovalInfoPOList().forEach(approvalInfoPO -> approvalInfoPO.setLeaveId(leavePO.getId()));
        approvalInfoDao.saveAll(leavePO.getHistoryApprovalInfoPOList());
    }

    public void saveEvent(LeaveEventPO leaveEventPO){
        leaveEventDao.save(leaveEventPO);
    }

    @Override
    public LeavePO findById(String id) {
        return leaveDao.findById(id)
                .orElseThrow(() -> new RuntimeException("leave not found"));
    }

    @Override
    public List<LeavePO> queryByApplicantId(String applicantId) {
        List<LeavePO> leavePOList = leaveDao.queryByApplicantId(applicantId);
        leavePOList
                .forEach(leavePO -> {
                    List<ApprovalInfoPO> approvalInfoPOList = approvalInfoDao.queryByLeaveId(leavePO.getId());
                    leavePO.setHistoryApprovalInfoPOList(approvalInfoPOList);
                });
        return leavePOList;
    }

    @Override
    public List<LeavePO> queryByApproverId(String approverId) {
        List<LeavePO> leavePOList = leaveDao.queryByApproverId(approverId);
        leavePOList
                .forEach(leavePO -> {
                    List<ApprovalInfoPO> approvalInfoPOList = approvalInfoDao.queryByLeaveId(leavePO.getId());
                    leavePO.setHistoryApprovalInfoPOList(approvalInfoPOList);
                });
        return leavePOList;
    }

}
