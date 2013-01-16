package org.motechproject.tama.migration.document;

import lombok.Data;
import org.ektorp.support.TypeDiscriminator;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.motechproject.model.Time;
import org.motechproject.tama.common.domain.CouchEntity;

import static org.motechproject.util.DateUtil.setTimeZone;

@TypeDiscriminator("doc.documentType == 'DosageAdherenceLog'")
@Data
public class DosageAdherenceLog extends CouchEntity {

    private String patientId;

    private String regimenId;

    private String dosageId;

    private LocalDate dosageDate;

    private String dosageStatus;

    private String reason;

    private boolean dosageTakenLate;

    private DateTime dosageStatusUpdatedAt;

    private String treatmentAdviceId;

    private Time dosageTime;

    public void setDosageStatusUpdatedAt(DateTime dateTime) {
        dateTime = setTimeZone(dateTime);
        this.dosageStatusUpdatedAt = dateTime;
    }
}
