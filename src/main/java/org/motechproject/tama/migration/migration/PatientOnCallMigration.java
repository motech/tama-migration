package org.motechproject.tama.migration.migration;

import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.tama.ivr.domain.CallLog;
import org.motechproject.tama.migration.fact.PatientOnCallFact;
import org.motechproject.tama.migration.relations.AllPatientsOnCallFacts;
import org.motechproject.tama.migration.repository.AllCallLogDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang.StringUtils.isNotBlank;

@Component
public class PatientOnCallMigration extends Migration<CallLog> {

    private AllPatientsOnCallFacts allPatientsOnCallFacts;

    @Autowired
    public PatientOnCallMigration(AllCallLogDocuments allCallLogDocuments, AllPatientsOnCallFacts allPatientsOnCallFacts) {
        super(allCallLogDocuments);
        this.allPatientsOnCallFacts = allPatientsOnCallFacts;
    }

    @Seed(version = "3.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(CallLog document) {
        if (isNotBlank(document.patientId())) {
            allPatientsOnCallFacts.save(new PatientOnCallFact(document.getCallId(), document.patientId()));
        } else if (isNotEmpty(document.getLikelyPatientIds())) {
            for (String patientId : document.getLikelyPatientIds()) {
                allPatientsOnCallFacts.save(new PatientOnCallFact(document.getCallId(), patientId));
            }
        }
    }
}
