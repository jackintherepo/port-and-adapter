package com.example.portandadapter.board.application.port.in;

import com.example.portandadapter.board.application.port.model.PostCommand;
import com.example.portandadapter.board.domain.Post;

import java.util.UUID;

public interface PostCommandInPort {

    Post writePost(PostCommand.WritePost command);

    Post modifyPost(UUID postId, PostCommand.ModifyPost command);

    void deletePost(UUID postId);

}
