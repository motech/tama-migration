package org.motechproject.tama.migration.repository;

import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.View;
import org.motechproject.tama.migration.document.DosageAdherenceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllDosageDocuments extends CouchDbRepositorySupport<DosageAdherenceLog> implements Paged<DosageAdherenceLog> {

    @Autowired
    protected AllDosageDocuments(@Qualifier("migrationDbConnector") CouchDbConnector db) {
        super(DosageAdherenceLog.class, db);
        initStandardDesignDocument();
    }

    @View(name = "all_documents_of_type", map = "function(doc) { if(doc.documentType === 'DosageAdherenceLog') { emit(null, doc._id); } }")
    public List<DosageAdherenceLog> get(int skip, int limit) {
        ViewQuery query = createQuery("all_documents_of_type").includeDocs(true).skip(skip).limit(limit);
        return db.queryView(query, DosageAdherenceLog.class);
    }
}
