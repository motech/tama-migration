package org.motechproject.tama.migration.relations;

import org.motechproject.tama.migration.fact.SMSFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllSMSFacts extends JpaRepository<SMSFact, Long> {
}
