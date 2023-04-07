package com.example.portandadapter.board.application;

import com.example.portandadapter.board.application.port.in.CommentCommandInPort;
import com.example.portandadapter.board.application.port.in.PostQueryInSystemPort;
import com.example.portandadapter.board.application.port.out.CommentOutPort;
import com.example.portandadapter.board.application.port.model.CommentCommand;
import com.example.portandadapter.board.domain.Comment;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CommentCommandService implements CommentCommandInPort {

    private final CommentOutPort commentOutPort;

    private final PostQueryInSystemPort postQueryInSystemPort;

    public Comment writeComment(CommentCommand.WriteComment command) {
        if (postQueryInSystemPort.existPost(command.getPostId())) {
            throw new RuntimeException("post not found");
        }

        UUID userId = UUID.randomUUID(); //로그인 유저 정보를 가져왔다고 가정

        return commentOutPort.save(
                Comment.builder()
                        .postId(command.getPostId())
                        .writerId(userId)
                        .body(command.getBody())
                        .build()
        );
    }

    public void deleteComment(UUID commentId) {
        Comment comment = commentOutPort.findById(commentId)
                .orElseThrow(() -> new RuntimeException("comment not found"));

        commentOutPort.delete(comment);
    }

}
