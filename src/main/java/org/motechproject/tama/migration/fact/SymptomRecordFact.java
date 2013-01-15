package org.motechproject.tama.migration.fact;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "symptom_recorded")
@Data
public class SymptomRecordFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "call_id")
    private String callId;

    @Column(name = "symptom_id")
    private String symptomId;

    public SymptomRecordFact() {
    }

    public SymptomRecordFact(String callId, String symptomId) {
        this.callId = callId;
        this.symptomId = symptomId;
    }
}
