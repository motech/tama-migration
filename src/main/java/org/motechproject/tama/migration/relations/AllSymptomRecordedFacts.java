package org.motechproject.tama.migration.relations;


import org.motechproject.tama.migration.fact.SymptomRecordFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllSymptomRecordedFacts extends JpaRepository<SymptomRecordFact, Long> {
}
