package com.github.bilakpoc.couchbasepoc.persistence.couchbase.repository;

import org.springframework.data.couchbase.repository.ReactiveCouchbaseSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.bilakpoc.couchbasepoc.persistence.couchbase.model.Beer;


/**
 * @author Lukáš Vasek
 */
@Repository
public interface BeerRepository extends ReactiveCouchbaseSortingRepository<Beer, String> {
}
