package org.eustrosoft.dto;

import org.eustrosoft.model.Comment;

public class CommentDTO {
    private String comment;
    private Long commentDate;
    private String user;

    public CommentDTO(Comment original) {
        setUser(original.getUser());
        setComment(original.getComment());
        setCommentDate(original.getCreationDate().getTime());
    }

    public static CommentDTO from(Comment original) {
        return new CommentDTO(original);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Long commentDate) {
        this.commentDate = commentDate;
    }
}
