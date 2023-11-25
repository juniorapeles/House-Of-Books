package com.techlibrary.houseofbooks.repositories;

import com.techlibrary.houseofbooks.entities.PublishingCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPublishingCompany extends JpaRepository <PublishingCompany,Long> {
}
