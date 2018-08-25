package com.github.bilakpoc.couchbasepoc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.CouchbaseConfigurationSupport;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;
import org.springframework.data.couchbase.repository.support.IndexManager;

/**
 * @author Lukáš Vasek
 */
@Configuration
@EnableReactiveCouchbaseRepositories(basePackages = {"com.github.bilakpoc.couchbasepoc.persistence.couchbase"})
public class CouchBaseConfiguration extends CouchbaseConfigurationSupport {

    @Override
    public String typeKey() {
        return "type";
    }

    @Override
    public IndexManager indexManager() {
        return new IndexManager(true, true, true);
    }
}
