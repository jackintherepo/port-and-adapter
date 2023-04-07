package com.example.portandadapter.board.application.port.model;

import lombok.Getter;

import java.util.UUID;

public class CommentCommand {

    @Getter
    public static class WriteComment {

        private UUID postId;
        private String body;
    }

}
