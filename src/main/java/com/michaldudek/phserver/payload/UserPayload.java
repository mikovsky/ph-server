package com.michaldudek.phserver.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPayload {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "login")
    private String username;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "avatar_url")
    private String avatarUrl;

    @JsonProperty(value = "public_repos")
    private Long publicRepositories;

    @JsonProperty(value = "followers")
    private Long followers;

    @JsonProperty(value = "html_url")
    private String htmlUrl;

    @JsonProperty(value = "created_at")
    private Date createdAt;

}
