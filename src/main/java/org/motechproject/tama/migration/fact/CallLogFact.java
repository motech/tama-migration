package org.motechproject.tama.migration.fact;

import lombok.Data;
import org.joda.time.DateTime;
import org.motechproject.tama.ivr.domain.CallLog;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "call_log")
@Data
public class CallLogFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "call_id")
    private String callId;

    @Column(name = "call_direction")
    private String callDirection;

    @Column(name = "call_language")
    private String language;

    @Column(name = "clinic_id")
    private String clinicId;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "phone_number")
    private String phoneNumber;

    public CallLogFact() {
    }

    public CallLogFact(CallLog callLog) {
        callId = callLog.getCallId();
        callDirection = callLog.getCallDirection().name();
        language = callLog.callLanguage();
        clinicId = callLog.clinicId();
        startTime = date(callLog.getStartTime());
        endTime = date(callLog.getEndTime());
        phoneNumber = callLog.getPhoneNumber();
    }

    private Date date(DateTime time) {
        return (null == time) ? null : time.toDate();
    }
}
