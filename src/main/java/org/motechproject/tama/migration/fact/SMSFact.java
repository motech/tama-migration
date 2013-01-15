package org.motechproject.tama.migration.fact;

import lombok.Data;
import org.motechproject.tama.ivr.domain.SMSLog;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sms_sent")
@Data
public class SMSFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "message")
    private String message;

    @Column(name = "sent_date_time")
    private Date sentDateTime;

    public SMSFact() {
    }

    public SMSFact(SMSLog smsLog) {
        this.recipient = smsLog.getRecipient();
        this.message = smsLog.getMessage();
        this.sentDateTime = smsLog.getSentDateTime().toDate();
    }
}
