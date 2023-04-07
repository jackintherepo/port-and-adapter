package com.example.portandadapter.board.application.port.out;

import com.example.portandadapter.board.domain.Post;

import java.util.Optional;
import java.util.UUID;

public interface PostOutPort {

    Optional<Post> findById(UUID postId);

    void delete(Post post);

}
