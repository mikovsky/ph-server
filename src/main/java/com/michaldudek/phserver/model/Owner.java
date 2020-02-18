package com.michaldudek.phserver.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Owner {

    private String username;

    private String avatarUrl;

}
