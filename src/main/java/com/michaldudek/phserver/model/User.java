package com.michaldudek.phserver.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@Document
public class User {

    @Id
    private Long id;

    private String username;

    private String name;

    private String avatarUrl;

    private Long publicRepositories;

    private Long followers;

    private String htmlUrl;

    private Date createdAt;

}
