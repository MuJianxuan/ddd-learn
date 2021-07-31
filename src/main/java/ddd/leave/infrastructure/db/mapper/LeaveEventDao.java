package ddd.leave.infrastructure.db.mapper;

import ddd.leave.infrastructure.db.po.LeaveEventPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveEventDao extends JpaRepository<LeaveEventPO, String> {

}
