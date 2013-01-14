package org.motechproject.tama.migration.relations;


import org.motechproject.tama.migration.fact.CallLogFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllCallLogFacts extends JpaRepository<CallLogFact, Long> {
}
