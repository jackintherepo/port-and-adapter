package com.example.portandadapter.board.application;

import com.example.portandadapter.board.application.port.in.PostQueryInPort;
import com.example.portandadapter.board.application.port.in.PostQueryInSystemPort;
import com.example.portandadapter.board.application.port.model.PostReadModel;
import com.example.portandadapter.board.application.port.out.PostQueryOutPort;
import com.example.portandadapter.board.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
//Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostQueryService implements PostQueryInPort, PostQueryInSystemPort {

    private final PostQueryOutPort postQueryOutPort;

    //PostQueryInPort의 구현부
    @Override
    public List<PostReadModel.List> listPost() {
        return postQueryOutPort.listPost();
    }

    @Override
    public PostReadModel.Detail detailPost(UUID postId) {
        return postQueryOutPort.detailPost(postId)
                .orElseThrow(() -> new RuntimeException("post not found"));
    }

    //PostQueryInSystemPort의 구현부
    @Override
    public Post getPost(UUID postId) {
        return postQueryOutPort.findById(postId)
                .orElseThrow(() -> new RuntimeException("post not found"));
    }

    @Override
    public boolean existPost(UUID postId) {
        return postQueryOutPort.existPost(postId);
    }

}
