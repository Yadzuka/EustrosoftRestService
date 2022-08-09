package org.eustrosoft.dto;

import org.eustrosoft.model.Comment;

import java.util.Date;

public class CommentCreationDTO {
    private String user;
    private String comment;
    private Date date;

    public CommentCreationDTO() {
        this.date = new Date();
    }

    public CommentCreationDTO(String user, String comment) {
        this.user = user;
        this.comment = comment;
        this.date = new Date();
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

    public Date getDate() {
        return date;
    }

    public Comment toDbObject() {
        Comment comment = new Comment();
        comment.setUser(getUser());
        comment.setComment(getComment());
        comment.setCreationDate(getDate());
        return comment;
    }
}
