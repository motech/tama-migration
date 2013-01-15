package org.motechproject.tama.migration.migration;

import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.tama.migration.document.SymptomReport;
import org.motechproject.tama.migration.fact.SymptomReportFact;
import org.motechproject.tama.migration.relations.AllSymptomReportFacts;
import org.motechproject.tama.migration.repository.AllSymptomReportDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SymptomReportMigration extends Migration<SymptomReport> {

    private AllSymptomReportFacts allSymptomReportFacts;

    @Autowired
    public SymptomReportMigration(AllSymptomReportDocuments allSymptomReportDocuments, AllSymptomReportFacts allSymptomReportFacts) {
        super(allSymptomReportDocuments);
        this.allSymptomReportFacts = allSymptomReportFacts;
    }

    @Seed(version = "6.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(SymptomReport document) {
        allSymptomReportFacts.save(new SymptomReportFact(document));
    }
}
