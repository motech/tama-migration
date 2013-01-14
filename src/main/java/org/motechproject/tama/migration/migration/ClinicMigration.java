package org.motechproject.tama.migration.migration;

import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.tama.facility.domain.Clinic;
import org.motechproject.tama.migration.fact.ClinicFact;
import org.motechproject.tama.migration.relations.AllClinicFacts;
import org.motechproject.tama.migration.repository.AllClinicDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClinicMigration extends Migration<Clinic> {

    private AllClinicFacts allClinicFacts;

    @Autowired
    public ClinicMigration(AllClinicDocuments allClinicDocuments, AllClinicFacts allClinicFacts) {
        super(allClinicDocuments);
        this.allClinicFacts = allClinicFacts;
    }

    @Seed(version = "2.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(Clinic document) {
        allClinicFacts.save(new ClinicFact(document));
    }
}
