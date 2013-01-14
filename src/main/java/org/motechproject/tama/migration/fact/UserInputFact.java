package org.motechproject.tama.migration.fact;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.motechproject.ivr.event.CallEvent;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static java.lang.Long.valueOf;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;
import static org.motechproject.util.DateUtil.newDateTime;

@Entity
@Table(name = "user_input_event")
@Data
public class UserInputFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "call_id")
    private String callId;

    @Column(name = "tree_name")
    private String treeName;

    @Column(name = "request")
    private String request;

    @Column(name = "user_input")
    private String userInput;

    @Column(name = "call_event_id")
    private String callEventId;

    @Column(name = "previous_event_id")
    private String previousEventId;

    @Column(name = "next_event_id")
    private String nextEventId;

    @Column(name = "response")
    private String response;

    @Column(name = "occurred_at")
    private Date occurredAt;

    @Column(name = "duration")
    private Long duration;

    public UserInputFact(String callId, int index, CallEvent event, SimpleCallEventFact previousEvent, SimpleCallEventFact nextEvent) {
        this.callId = callId;
        this.treeName = returnFirst(event.getData().getData().get("treeName"));
        this.request = previousEvent.getResponse();
        this.userInput = returnFirst(event.getData().getData().get("dtmfData"));
        this.callEventId = callId + "/event/" + index;
        this.previousEventId = previousEvent.getCallEventId();
        this.nextEventId = nextEvent.getCallEventId();
        this.response = buildXML(event.getData().getData().get("responseXML"));
        this.occurredAt = event.getTimeStamp().toDate();
        this.duration = valueOf(new Period(newDateTime(previousEvent.getOccurredAt()), event.getTimeStamp(), PeriodType.seconds()).getMillis());
    }

    private String returnFirst(List<String> treeNames) {
        if (isNotEmpty(treeNames)) {
            return treeNames.get(0);
        } else {
            return "";
        }
    }

    private String buildXML(List<String> wavFiles) {
        StringBuilder builder = new StringBuilder();
        if (CollectionUtils.isNotEmpty(wavFiles)) {
            for (String response : wavFiles) {
                builder.append(response);
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
