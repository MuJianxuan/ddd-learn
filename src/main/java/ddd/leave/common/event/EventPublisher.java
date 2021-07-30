package ddd.leave.common.event;

import ddd.leave.domain.event.LeaveEvent;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    public void publish(LeaveEvent event){
        //send to MQ
        //mq.send(event);
    }
}