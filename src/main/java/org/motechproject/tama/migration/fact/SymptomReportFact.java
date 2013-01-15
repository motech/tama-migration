package org.motechproject.tama.migration.fact;

import lombok.Data;
import org.joda.time.DateTime;
import org.motechproject.tama.common.TAMAConstants;
import org.motechproject.tama.migration.document.SymptomReport;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "symptom_report")
@Data
public class SymptomReportFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "call_id")
    private String callId;

    @Column(name = "doctor_contacted")
    private String doctorContacted;

    @Column(name = "patient_doc_id")
    private String patientDocId;

    @Column(name = "reported_at")
    private Date reportedAt;

    @Column(name = "advice_given")
    private String adviceGiven;

    public SymptomReportFact() {
    }

    public SymptomReportFact(SymptomReport symptomReport) {
        callId = symptomReport.getCallId();
        doctorContacted = doctorContacted(symptomReport);
        patientDocId = symptomReport.getPatientDocId();
        reportedAt = symptomReport.getReportedAt().toDate();
        adviceGiven = symptomReport.getAdviceGiven();
    }

    private String doctorContacted(SymptomReport symptomReport) {
        TAMAConstants.ReportedType contacted = symptomReport.getDoctorContacted();
        return (null == contacted) ? "" : contacted.name();
    }
}
