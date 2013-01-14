package org.motechproject.tama.migration.migration;

import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.tama.facility.domain.Clinic;
import org.motechproject.tama.migration.fact.ClinicContactFact;
import org.motechproject.tama.migration.relations.AllClinicContactFacts;
import org.motechproject.tama.migration.repository.AllClinicDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

@Component
public class ClinicContactMigration extends Migration<Clinic> {

    private AllClinicContactFacts allClinicFacts;

    @Autowired
    public ClinicContactMigration(AllClinicDocuments allClinicDocuments, AllClinicContactFacts allClinicContactFacts) {
        super(allClinicDocuments);
        this.allClinicFacts = allClinicContactFacts;
    }

    @Seed(version = "2.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(Clinic document) {
        List<Clinic.ClinicianContact> clinicianContacts = document.getClinicianContacts();
        if (isNotEmpty(clinicianContacts)) {
            for (Clinic.ClinicianContact clinicianContact : clinicianContacts) {
                allClinicFacts.save(new ClinicContactFact(clinicianContact.getName(), clinicianContact.getPhoneNumber()));
            }
        }
    }
}
