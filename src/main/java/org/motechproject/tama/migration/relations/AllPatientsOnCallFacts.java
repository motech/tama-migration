package org.motechproject.tama.migration.relations;


import org.motechproject.tama.migration.fact.PatientOnCallFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllPatientsOnCallFacts extends JpaRepository<PatientOnCallFact, Long> {
}
