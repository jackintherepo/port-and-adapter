package com.example.portandadapter.board.application.port.out;

import com.example.portandadapter.board.domain.Comment;

import java.util.Optional;
import java.util.UUID;

public interface CommentOutPort {

    Comment save(Comment comment);

    Optional<Comment> findById(UUID commentId);

    void delete(Comment comment);

}
