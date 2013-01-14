package org.motechproject.tama.migration.relations;

import org.motechproject.tama.migration.fact.UserInputFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllUserInputEvents extends JpaRepository<UserInputFact, Long> {
}
