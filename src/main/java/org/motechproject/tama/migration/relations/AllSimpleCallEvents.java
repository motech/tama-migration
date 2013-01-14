package org.motechproject.tama.migration.relations;

import org.motechproject.tama.migration.fact.SimpleCallEventFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllSimpleCallEvents extends JpaRepository<SimpleCallEventFact, Long> {
}
