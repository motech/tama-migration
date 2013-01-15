package org.motechproject.tama.migration.migration;

import org.apache.commons.collections.CollectionUtils;
import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.tama.migration.document.SymptomReport;
import org.motechproject.tama.migration.fact.SymptomRecordFact;
import org.motechproject.tama.migration.relations.AllSymptomRecordedFacts;
import org.motechproject.tama.migration.repository.AllSymptomReportDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SymptomRecordedMigration extends Migration<SymptomReport> {

    private AllSymptomRecordedFacts allSymptomRecordFacts;

    @Autowired
    public SymptomRecordedMigration(AllSymptomReportDocuments allSymptomReportDocuments, AllSymptomRecordedFacts allSymptomRecordFacts) {
        super(allSymptomReportDocuments);
        this.allSymptomRecordFacts = allSymptomRecordFacts;
    }

    @Seed(version = "7.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(SymptomReport document) {
        List<String> symptomIds = document.getSymptomIds();
        if (CollectionUtils.isNotEmpty(symptomIds)) {
            for (String symptomId : symptomIds) {
                allSymptomRecordFacts.save(new SymptomRecordFact(document.getCallId(), symptomId));
            }
        }
    }
}
