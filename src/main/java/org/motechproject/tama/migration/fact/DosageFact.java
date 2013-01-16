package org.motechproject.tama.migration.fact;

import lombok.Data;
import org.motechproject.tama.migration.document.DosageAdherenceLog;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dosage")
@Data
public class DosageFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "dosage_date")
    private Date dosageDate;

    @Column(name = "dosage_status")
    private String dosageStatus;

    @Column(name = "reason")
    private String reason;

    @Column(name = "dosage_taken_late")
    private boolean dosageTakenLate;

    @Column(name = "dosage_status_updated_at")
    private Date dosageStatusUpdatedAt;

    public DosageFact() {
    }

    public DosageFact(DosageAdherenceLog document) {
        patientId = document.getPatientId();
        dosageDate = document.getDosageDate().toDate();
        dosageStatus = document.getDosageStatus();
        reason = document.getReason();
        dosageTakenLate = document.isDosageTakenLate();
        dosageStatusUpdatedAt = document.getDosageStatusUpdatedAt().toDate();
    }
}
