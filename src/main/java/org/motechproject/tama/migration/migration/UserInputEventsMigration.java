package org.motechproject.tama.migration.migration;

import org.motechproject.deliverytools.seed.Seed;
import org.motechproject.ivr.event.CallEvent;
import org.motechproject.tama.ivr.domain.CallLog;
import org.motechproject.tama.migration.fact.SimpleCallEventFact;
import org.motechproject.tama.migration.fact.UserInputFact;
import org.motechproject.tama.migration.relations.AllUserInputEvents;
import org.motechproject.tama.migration.repository.AllCallLogDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserInputEventsMigration extends Migration<CallLog> {

    public static final int ALLOW_NEW_CALL_AND_HANGUP = 2;

    private AllUserInputEvents allUserInputEvents;

    @Autowired
    public UserInputEventsMigration(AllCallLogDocuments allCallLogDocuments, AllUserInputEvents allUserInputEvents) {
        super(allCallLogDocuments);
        this.allUserInputEvents = allUserInputEvents;
    }

    @Seed(version = "5.0", priority = 0)
    public void migrate() {
        super.migrate();
    }

    @Override
    protected void save(CallLog document) {
        List<CallEvent> callEvents = document.getCallEvents();
        if (callEvents.size() <= ALLOW_NEW_CALL_AND_HANGUP) {
            return;
        }
        for (int i = 1; i < callEvents.size() - 1; i++) {
            CallEvent event = callEvents.get(i);
            if ("GotDTMF".equals(event.getName())) {
                SimpleCallEventFact previousEvent = createFact(document, callEvents.get(i - 1), i - 1);
                SimpleCallEventFact nextEvent = createFact(document, callEvents.get(i + 1), i + 1);
                allUserInputEvents.save(createFact(document, event, i, previousEvent, nextEvent));
            }
        }
    }

    private SimpleCallEventFact createFact(CallLog document, CallEvent event, int i) {
        return new SimpleCallEventFact(event.getName(), document.getId(), document.getPhoneNumber(), document.getCallId(), document.getStartTime().toDate(), i, event);
    }

    private UserInputFact createFact(CallLog document, CallEvent event, int i, SimpleCallEventFact previousEvent, SimpleCallEventFact nextEvent) {
        return new UserInputFact(document.getCallId(), i, event, previousEvent, nextEvent);
    }
}
