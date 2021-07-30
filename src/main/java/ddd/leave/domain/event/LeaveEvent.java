package ddd.leave.domain.event;

import com.alibaba.fastjson.JSON;
import ddd.leave.common.event.DomainEvent;
import ddd.leave.domain.entity.Leave;
import lombok.Data;

import java.util.Date;

@Data
public class LeaveEvent extends DomainEvent {

    LeaveEventType leaveEventType;

    public static LeaveEvent create(LeaveEventType eventType, Leave leave){
        LeaveEvent event = new LeaveEvent();
//        event.setId(IdGenerator.nextId());
        event.setLeaveEventType(eventType);
        event.setTimestamp(new Date());
        event.setData(JSON.toJSONString(leave));
        return event;
    }
}
