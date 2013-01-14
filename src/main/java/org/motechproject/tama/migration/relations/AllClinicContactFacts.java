package org.motechproject.tama.migration.relations;


import org.motechproject.tama.migration.fact.ClinicContactFact;
import org.motechproject.tama.migration.fact.ClinicFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllClinicContactFacts extends JpaRepository<ClinicContactFact, Long> {
}
