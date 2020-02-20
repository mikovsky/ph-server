package com.michaldudek.phserver.mapper;

import com.michaldudek.phserver.model.Owner;
import com.michaldudek.phserver.model.Repository;
import com.michaldudek.phserver.model.User;
import com.michaldudek.phserver.payload.OwnerPayload;
import com.michaldudek.phserver.payload.RepositoryPayload;
import com.michaldudek.phserver.payload.UserPayload;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Component
public class ModelMappers {

    public Collection<Repository> mapRepositoriesPayloadToRepositories(Collection<RepositoryPayload> payloads) {
        return payloads
                .stream()
                .map(this::mapRepositoryPayloadToRepository)
                .collect(toList());
    }

    public Repository mapRepositoryPayloadToRepository(RepositoryPayload payload) {
        return Repository.builder()
                .id(payload.getId())
                .owner(mapOwnerPayloadToOwner(payload.getOwnerPayload()))
                .name(payload.getName())
                .description(payload.getDescription())
                .forks(payload.getForks())
                .watchers(payload.getWatchers())
                .htmlUrl(payload.getHtmlUrl())
                .stars(payload.getStars())
                .createdAt(payload.getCreatedAt())
                .build();
    }

    public Owner mapOwnerPayloadToOwner(OwnerPayload payload) {
        return Owner.builder()
                .username(payload.getUsername())
                .avatarUrl(payload.getAvatarUrl())
                .build();
    }

    public User mapUserPayloadToUser(UserPayload payload) {
        return User.builder()
                .id(payload.getId())
                .username(payload.getUsername())
                .name(payload.getName())
                .avatarUrl(payload.getAvatarUrl())
                .publicRepositories(payload.getPublicRepositories())
                .followers(payload.getFollowers())
                .htmlUrl(payload.getHtmlUrl())
                .createdAt(payload.getCreatedAt())
                .build();
    }

}
