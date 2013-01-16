package org.motechproject.tama.migration.migration;

import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.tama.migration.document.DosageAdherenceLog;
import org.motechproject.tama.migration.fact.DosageFact;
import org.motechproject.tama.migration.relations.AllDosageFacts;
import org.motechproject.tama.migration.repository.AllDosageDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DosageMigration extends Migration<DosageAdherenceLog> {

    private AllDosageFacts allDosageFacts;

    @Autowired
    public DosageMigration(AllDosageDocuments allDosageDocuments, AllDosageFacts allDosageFacts) {
        super(allDosageDocuments);
        this.allDosageFacts = allDosageFacts;
    }

    @Seed(version = "9.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(DosageAdherenceLog document) {
        allDosageFacts.save(new DosageFact(document));
    }
}
