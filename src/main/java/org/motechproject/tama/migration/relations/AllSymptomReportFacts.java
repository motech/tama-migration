package org.motechproject.tama.migration.relations;


import org.motechproject.tama.migration.fact.SymptomReportFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllSymptomReportFacts extends JpaRepository<SymptomReportFact, Long> {
}
