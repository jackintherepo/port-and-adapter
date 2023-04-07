package com.example.portandadapter.board.application.port.in;

import com.example.portandadapter.board.application.port.model.CommentCommand;
import com.example.portandadapter.board.domain.Comment;

import java.util.UUID;

public interface CommentCommandInPort {

    Comment writeComment(CommentCommand.WriteComment command);

    void deleteComment(UUID commentId);

}
