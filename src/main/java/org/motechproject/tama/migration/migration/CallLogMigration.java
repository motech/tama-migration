package org.motechproject.tama.migration.migration;

import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.tama.ivr.domain.CallLog;
import org.motechproject.tama.migration.fact.CallLogFact;
import org.motechproject.tama.migration.relations.AllCallLogFacts;
import org.motechproject.tama.migration.repository.AllCallLogDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallLogMigration extends Migration<CallLog> {

    private AllCallLogFacts allCallLogFacts;

    @Autowired
    public CallLogMigration(AllCallLogDocuments allCallLogDocuments, AllCallLogFacts allCallLogFacts) {
        super(allCallLogDocuments);
        this.allCallLogFacts = allCallLogFacts;
    }

    @Seed(version = "3.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(CallLog document) {
        allCallLogFacts.save(new CallLogFact(document));
    }
}
