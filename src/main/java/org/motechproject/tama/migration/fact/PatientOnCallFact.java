package org.motechproject.tama.migration.fact;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "patient_on_call")
@Data
public class PatientOnCallFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "call_id")
    private String callId;

    @Column(name = "patient_id")
    private String patientId;

    public PatientOnCallFact() {
    }

    public PatientOnCallFact(String callId, String patientId) {
        this.callId = callId;
        this.patientId = patientId;
    }
}
