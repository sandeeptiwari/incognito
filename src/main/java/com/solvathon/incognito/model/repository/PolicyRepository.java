package com.solvathon.incognito.model.repository;

import com.solvathon.incognito.model.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    @Query("SELECT q from Policy q where q.quote = true")
    List<Policy> findAllQuotes();
}
