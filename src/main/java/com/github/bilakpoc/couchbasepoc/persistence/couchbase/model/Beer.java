package com.github.bilakpoc.couchbasepoc.persistence.couchbase.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.Data;

/**
 * @author Lukáš Vasek
 */
@Data
@Document
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "beer")
public class Beer {

    @Id
    private String id;

    @Field
    private BigDecimal abv;

    @Field
    private String breweryId;

    @Field
    private String category;

    @Field
    private String description;

    @Field
    private BigDecimal ibu;

    @Field
    private String name;

    @Field
    private BigDecimal srm;

    @Field
    private String style;

    @Field
    private BigDecimal upc;

    @Field
    private LocalDateTime updated;
}
