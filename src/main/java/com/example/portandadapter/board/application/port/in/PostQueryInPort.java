package com.example.portandadapter.board.application.port.in;

import com.example.portandadapter.board.application.port.model.PostReadModel;

import java.util.List;
import java.util.UUID;

public interface PostQueryInPort {

    List<PostReadModel.List> listPost();

    PostReadModel.Detail detailPost(UUID postId);

}
