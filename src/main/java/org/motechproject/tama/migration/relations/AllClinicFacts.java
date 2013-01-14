package org.motechproject.tama.migration.relations;


import org.motechproject.tama.migration.fact.ClinicFact;
import org.motechproject.tama.migration.fact.PatientFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllClinicFacts extends JpaRepository<ClinicFact, Long> {
}
