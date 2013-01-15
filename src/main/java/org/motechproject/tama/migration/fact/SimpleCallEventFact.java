package org.motechproject.tama.migration.fact;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.motechproject.ivr.event.CallEvent;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "simple_call_event")
@Data
public class SimpleCallEventFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "call_event_id")
    private String callEventId;

    @Column(name = "call_start_time")
    private Date callStartTime;

    @Column(name = "call_id")
    private String callId;

    @Column(name = "previous_event_id")
    private String previousEventId;

    @Column(name = "next_event_id")
    private String nextEventId;

    @Column(name = "response")
    private String response;

    @Column(name = "occurred_at")
    private Date occurredAt;

    public SimpleCallEventFact() {

    }

    public SimpleCallEventFact(String name, String callId, Date callStartTime, int occurrenceInCall, CallEvent callEvent) {
        this.name = name;
        this.callId = callId;
        this.callStartTime = callStartTime;
        this.callEventId = callId + "/event/" + Integer.toString(occurrenceInCall);
        this.response = buildResponse(callEvent.getData().getData().get("responseXML"));
        this.occurredAt = callEvent.getTimeStamp().toDate();
    }

    public void previous(SimpleCallEventFact previousEvent) {
        this.previousEventId = previousEvent.getCallEventId();
    }

    public void next(SimpleCallEventFact nextEvent) {
        this.nextEventId = nextEvent.getCallEventId();
    }

    private String buildResponse(List<String> responseXML) {
        StringBuilder builder = new StringBuilder();
        if (CollectionUtils.isNotEmpty(responseXML)) {
            for (String response : responseXML) {
                builder.append(response);
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
