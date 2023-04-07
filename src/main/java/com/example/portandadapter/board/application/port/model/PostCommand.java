package com.example.portandadapter.board.application.port.model;

import lombok.Getter;

import java.util.UUID;

public class PostCommand {

    @Getter
    public static class WritePost {

        private UUID boardId;
        private String title;
        private String body;
    }

    @Getter
    public static class ModifyPost {

        private String title;
        private String body;
    }

}
