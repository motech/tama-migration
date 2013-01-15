package org.motechproject.tama.migration.migration;

import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.tama.ivr.domain.SMSLog;
import org.motechproject.tama.migration.document.SymptomReport;
import org.motechproject.tama.migration.fact.SMSFact;
import org.motechproject.tama.migration.fact.SymptomReportFact;
import org.motechproject.tama.migration.relations.AllSMSFacts;
import org.motechproject.tama.migration.relations.AllSymptomReportFacts;
import org.motechproject.tama.migration.repository.AllSMSLogDocuments;
import org.motechproject.tama.migration.repository.AllSymptomReportDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SMSLogMigration extends Migration<SMSLog> {

    private AllSMSFacts allSMSFacts;

    @Autowired
    public SMSLogMigration(AllSMSLogDocuments allSMSLogDocuments, AllSMSFacts allSMSFacts) {
        super(allSMSLogDocuments);
        this.allSMSFacts = allSMSFacts;
    }

    @Seed(version = "8.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(SMSLog document) {
        allSMSFacts.save(new SMSFact(document));
    }
}
