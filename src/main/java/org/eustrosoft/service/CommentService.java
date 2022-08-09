package org.eustrosoft.service;

import lombok.RequiredArgsConstructor;
import org.eustrosoft.dao.CommentDAO;
import org.eustrosoft.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequestScope
@RequiredArgsConstructor
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private EntityManager entityManager;

    public List<Comment> findAll() {
        List<Comment> commentList = new ArrayList<>();
        Iterable<Comment> commentIterable = commentDAO.findAll();
        commentIterable.forEach(commentList::add);
        return commentList;
    }

    public Comment getById(Long id) {
        Optional<Comment> commentOptional = commentDAO.findById(id);
        return commentOptional.orElse(null);
    }

    public boolean createComment(Comment comment) {
        return (Boolean) entityManager.createNativeQuery(
                "SELECT tis.create_comment(:date, :user, :comment);"
        ).setParameter("date", comment.getCreationDate())
                .setParameter("user", comment.getUser())
                .setParameter("comment", comment.getComment())
                .getSingleResult();
    }
}
