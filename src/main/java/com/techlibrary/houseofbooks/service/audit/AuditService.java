package com.techlibrary.houseofbooks.service.audit;

import com.techlibrary.houseofbooks.domain.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import java.util.List;

public class AuditService {

    private final EntityManager entityManager;

    public AuditService(EntityManager em) {
        this.entityManager = em;
    }

    @Transactional
    public List<Number> listRevisions(Long bookId) {
        AuditReader reader = AuditReaderFactory.get(entityManager);
        return reader.getRevisions(Number.class, bookId);
    }

    @Transactional
    public Book getRevision(Long bookId, Number revision) {
        AuditReader reader = AuditReaderFactory.get(entityManager);
        return reader.find(Book.class, bookId, revision);
    }
}
