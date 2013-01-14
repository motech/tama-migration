package org.motechproject.tama.migration.migration;

import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.tama.migration.fact.PatientFact;
import org.motechproject.tama.migration.relations.AllPatientFacts;
import org.motechproject.tama.migration.repository.AllPatientDocuments;
import org.motechproject.tama.patient.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientMigration extends Migration<Patient> {

    private AllPatientFacts allPatientFacts;

    @Autowired
    public PatientMigration(AllPatientDocuments allPatientDocuments, AllPatientFacts allPatientFacts) {
        super(allPatientDocuments);
        this.allPatientFacts = allPatientFacts;
    }

    @Seed(version = "1.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(Patient document) {
        allPatientFacts.save(new PatientFact(document));
    }
}
