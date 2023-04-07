package com.example.portandadapter.board.application.port.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public class PostReadModel {

    public static class List {

        private UUID id;
        private UUID boardId;
        private UUID boardName;
        private UUID writerId;
        private UUID writerName;
        private String title;
        private String body;
        private long hit;
        private long commentCount;
        private OffsetDateTime createdAt;

        //QueryProjection
    }

    public static class Detail {

        private UUID id;
        private UUID boardId;
        private UUID boardName;
        private UUID writerId;
        private UUID writerName;
        private String title;
        private String body;
        private long hit;
        private long commentCount;
        private long prevPostId;
        private long nextPostId;
        private OffsetDateTime createdAt;
        private OffsetDateTime modifiedAt;

        //QueryProjection
    }

}
