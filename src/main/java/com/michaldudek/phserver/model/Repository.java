package com.michaldudek.phserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Repository {

    @Id
    private Long id;

    private Owner owner;

    private String name;

    private String description;

    private Long forks;

    private Long watchers;

    private String htmlUrl;

    private Long stars;

    private Date createdAt;

}
