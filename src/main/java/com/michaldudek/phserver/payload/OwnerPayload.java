package com.michaldudek.phserver.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerPayload {

    @JsonProperty(value = "login")
    private String username;

    @JsonProperty(value = "avatar_url")
    private String avatarUrl;

}
