package org.motechproject.tama.migration.repository;

import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.View;
import org.motechproject.tama.ivr.domain.CallLog;
import org.motechproject.tama.migration.document.SymptomReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllSymptomReportDocuments extends CouchDbRepositorySupport<SymptomReport> implements Paged<SymptomReport> {

    @Autowired
    protected AllSymptomReportDocuments(@Qualifier("migrationDbConnector") CouchDbConnector db) {
        super(SymptomReport.class, db);
        initStandardDesignDocument();
    }

    @View(name = "all_documents_of_type", map = "function(doc) { if(doc.documentType === 'SymptomReport') { emit(null, doc._id); } }")
    public List<SymptomReport> get(int skip, int limit) {
        ViewQuery query = createQuery("all_documents_of_type").includeDocs(true).skip(skip).limit(limit);
        return db.queryView(query, SymptomReport.class);
    }
}
