package org.motechproject.tama.migration.relations;


import org.motechproject.tama.migration.fact.DosageFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllDosageFacts extends JpaRepository<DosageFact, Long> {
}
