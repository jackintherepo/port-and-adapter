package com.example.portandadapter.board.application.port.out;

import com.example.portandadapter.board.application.port.model.PostReadModel;
import com.example.portandadapter.board.domain.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostQueryOutPort {

    List<PostReadModel.List> listPost();

    Optional<PostReadModel.Detail> detailPost(UUID postId);

    Optional<Post> findById(UUID postId);

    boolean existPost(UUID postId);

}
