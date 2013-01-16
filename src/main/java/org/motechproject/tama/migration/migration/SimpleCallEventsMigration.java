package org.motechproject.tama.migration.migration;

import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.ivr.event.CallEvent;
import org.motechproject.tama.ivr.domain.CallLog;
import org.motechproject.tama.migration.fact.SimpleCallEventFact;
import org.motechproject.tama.migration.relations.AllSimpleCallEvents;
import org.motechproject.tama.migration.repository.AllCallLogDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleCallEventsMigration extends Migration<CallLog> {

    private AllSimpleCallEvents allSimpleCallEvents;

    @Autowired
    public SimpleCallEventsMigration(AllCallLogDocuments allCallLogDocuments, AllSimpleCallEvents allSimpleCallEvents) {
        super(allCallLogDocuments);
        this.allSimpleCallEvents = allSimpleCallEvents;
    }

    @Seed(version = "4.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(CallLog document) {
        List<CallEvent> callEvents = document.getCallEvents();
        for (int i = 0; i < callEvents.size(); i++) {
            CallEvent event = callEvents.get(i);
            if (!"GotDTMF".equals(event.getName())) {
                SimpleCallEventFact fact = createFact(document, event, i);
                switch (position(callEvents.size(), i)) {
                    case 1:
                        fact.next(createFact(document, callEvents.get(i + 1), i + 1));
                        break;
                    case 2:
                        fact.previous(createFact(document, callEvents.get(i - 1), i - 1));
                        fact.next(createFact(document, callEvents.get(i + 1), i + 1));
                        break;
                    case 3:
                        fact.previous(createFact(document, callEvents.get(i - 1), i - 1));
                        break;
                }
                allSimpleCallEvents.save(fact);
            }
        }
    }

    private int position(int callEventsSize, int i) {
        if (i == 0) {
            return (i < callEventsSize - 1) ? 1 : 0;
        } else if (i < callEventsSize - 1) {
            return 2;
        } else {
            return 3;
        }
    }

    private SimpleCallEventFact createFact(CallLog document, CallEvent event, int i) {
        return new SimpleCallEventFact(event.getName(), document.getPhoneNumber(), document.getCallId(), document.getStartTime().toDate(), i, event);
    }
}
