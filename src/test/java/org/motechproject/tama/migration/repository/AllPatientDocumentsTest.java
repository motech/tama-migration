package org.motechproject.tama.migration.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AllPatientDocumentsTest {

    @Autowired
    AllPatientDocuments allPatientDocuments;

    @Test
    public void testFetch() {
        System.out.println(allPatientDocuments.get(1, 10));
    }
}
