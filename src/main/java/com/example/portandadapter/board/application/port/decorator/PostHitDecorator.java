package com.example.portandadapter.board.application.port.decorator;

import com.example.portandadapter.board.application.port.in.PostCommandInSystemPort;
import com.example.portandadapter.board.application.port.in.PostQueryInPort;
import com.example.portandadapter.board.application.port.model.PostReadModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Primary
@Service
public class PostHitDecorator implements PostQueryInPort {

    private final PostQueryInPort postQueryInPort;

    private final PostCommandInSystemPort postCommandInSystemPort;

    public PostHitDecorator(
            @Qualifier("postQueryService") PostQueryInPort postQueryInPort,
            PostCommandInSystemPort postCommandInSystemPort
    ) {
        this.postQueryInPort = postQueryInPort;
        this.postCommandInSystemPort = postCommandInSystemPort;
    }

    @Override
    public List<PostReadModel.List> listPost() {
        return postQueryInPort.listPost();
    }

    @Override
    //Transactional
    public PostReadModel.Detail detailPost(UUID postId) {
        PostReadModel.Detail post = postQueryInPort.detailPost(postId);

        postCommandInSystemPort.increaseHit(postId);

        return post;
    }

}
