package com.example.portandadapter.board.domain;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Comment {

    private UUID id;
    private UUID postId;
    private UUID writerId;
    private String body;
    private OffsetDateTime createdAt;

    @Builder
    public Comment(UUID postId, UUID writerId, String body) {
        this.id = UUID.randomUUID();
        this.postId = postId;
        this.writerId = writerId;
        this.body = body;
        this.createdAt = OffsetDateTime.now();
    }
}
