package com.michaldudek.phserver.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryPayload {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "owner")
    private OwnerPayload ownerPayload;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "forks")
    private Long forks;

    @JsonProperty(value = "watchers")
    private Long watchers;

    @JsonProperty(value = "html_url")
    private String htmlUrl;

    @JsonProperty(value = "stargazers_count")
    private Long stars;

    @JsonProperty(value = "created_at")
    private Date createdAt;

}
