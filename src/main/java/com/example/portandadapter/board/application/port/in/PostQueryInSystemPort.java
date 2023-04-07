package com.example.portandadapter.board.application.port.in;

import com.example.portandadapter.board.domain.Post;

import java.util.UUID;

public interface PostQueryInSystemPort {

    Post getPost(UUID postId);

    boolean existPost(UUID postId);

}
