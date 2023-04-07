package com.example.portandadapter.board.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
public class Post {

    private UUID id;
    private UUID boardId;
    private UUID writerId;
    private String title;
    private String body;
    private long hit;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    @Builder
    public Post(UUID boardId, UUID writerId, String title, String body) {
        this.id = UUID.randomUUID();
        this.boardId = boardId;
        this.writerId = writerId;
        this.title = title;
        this.body = body;
        this.hit = 0;
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    public Post increaseHit() {
        hit = hit + 1;
        return this;
    }

}
