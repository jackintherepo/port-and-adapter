package com.example.portandadapter.board.application;

import com.example.portandadapter.board.application.port.in.PostCommandInPort;
import com.example.portandadapter.board.application.port.model.PostCommand;
import com.example.portandadapter.board.application.port.out.PostOutPort;
import com.example.portandadapter.board.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
//Transactional
@RequiredArgsConstructor
public class PostCommandService implements PostCommandInPort {

    private final PostOutPort postOutPort;

    @Override
    public Post writePost(PostCommand.WritePost command) {
        return null;
    }

    @Override
    public Post modifyPost(UUID postId, PostCommand.ModifyPost command) {
        return null;
    }

    @Override
    public void deletePost(UUID postId) {

    }

}
