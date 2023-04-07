package com.example.portandadapter.board.adapter;

import com.example.portandadapter.board.application.port.in.PostCommandInPort;
import com.example.portandadapter.board.application.port.in.PostQueryInPort;
import com.example.portandadapter.board.application.port.model.PostCommand;
import com.example.portandadapter.board.application.port.model.PostReadModel;
import com.example.portandadapter.board.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PostWebAdapter {

    private final PostCommandInPort postCommandInPort;

    private final PostQueryInPort postQueryInPort;

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> writePost(
            @RequestBody PostCommand.WritePost command
    ) {
        Post post = postCommandInPort.writePost(command);

        return Map.of("id", post.getId());
    }

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> modifyPost(
            @PathVariable UUID postId,
            @RequestBody PostCommand.ModifyPost command
    ) {
        Post post = postCommandInPort.modifyPost(postId, command);

        return Map.of("id", post.getId());
    }

    @PostMapping("/posts/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(
            @PathVariable UUID postId
    ) {
        postCommandInPort.deletePost(postId);
    }

    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostReadModel.List> listPost() {
        return postQueryInPort.listPost();
    }

    @GetMapping("/posts/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public PostReadModel.Detail detailPost(
            @PathVariable UUID postId
    ) {
        return postQueryInPort.detailPost(postId);
    }

}
