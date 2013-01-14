package org.motechproject.tama.migration.repository;

import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.View;
import org.motechproject.tama.facility.domain.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllClinicDocuments extends CouchDbRepositorySupport<Clinic> implements Paged<Clinic> {

    @Autowired
    protected AllClinicDocuments(@Qualifier("migrationDbConnector") CouchDbConnector db) {
        super(Clinic.class, db);
        initStandardDesignDocument();
    }

    @View(name = "all_documents_of_type", map = "function(doc) { if(doc.documentType === 'Clinic') { emit(null, doc._id); } }")
    public List<Clinic> get(int skip, int limit) {
        ViewQuery query = createQuery("all_documents_of_type").includeDocs(true).skip(skip).limit(limit);
        return db.queryView(query, Clinic.class);
    }
}
