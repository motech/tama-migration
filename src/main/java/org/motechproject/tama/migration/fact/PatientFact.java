package org.motechproject.tama.migration.fact;

import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.motechproject.tama.patient.domain.Patient;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient")
@Data
public class PatientFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_doc_id")
    private String patientDocumentId;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "clinic_id")
    private String clinicId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "status")
    private String status;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "activation_date")
    private Date dateOfActivation;

    public PatientFact() {
    }

    public PatientFact(Patient patient) {
        patientDocumentId = patient.getId();
        patientId = patient.getPatientId();
        clinicId = patient.getClinic_id();
        status = patient.getStatus().getDisplayName();
        phoneNumber = patient.getMobilePhoneNumber();
        dateOfBirth = patient.getDateOfBirthAsDate();
        dateOfActivation = activationDate(patient);
        gender = gender(patient.getGenderId());
    }

    private Date activationDate(Patient patient) {
        DateTime activationDate = patient.getActivationDate();
        if (activationDate == null) {
            return null;
        } else {
            return activationDate.toDate();
        }
    }

    private String gender(String genderId) {
        if (StringUtils.equals("6b83fd0413b4956ed90cffff3800e8a0", genderId)) {
            return "F";
        } else {
            return "M";
        }
    }
}
