package org.eustrosoft.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eustrosoft.dto.CommentCreationDTO;
import org.eustrosoft.dto.CommentDTO;
import org.eustrosoft.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static org.eustrosoft.Constants.EUSTRO_QR_COOKIE;

@RestController
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<CommentDTO> getComments(HttpServletRequest request) throws Exception {
        boolean isNeeded = isRightCookie(request.getCookies());
        if (!isNeeded) {
            return null;
        }
        return commentService.findAll().stream()
                .map(CommentDTO::from).collect(Collectors.toList());
    }

    @GetMapping("/comments/{id}")
    public CommentDTO getComment(HttpServletRequest request, @PathVariable("id") Long id) throws Exception {
        boolean isNeeded = isRightCookie(request.getCookies());
        if (!isNeeded) {
            return null;
        }
        return CommentDTO.from(commentService.getById(id));
    }

    @PostMapping("/comments")
    public String createComment(HttpServletRequest request) throws Exception {
        boolean isNeeded = isRightCookie(request.getCookies());
        if (!isNeeded) {
            return "Failed cookie";
        }
        ObjectMapper mapper = new ObjectMapper();
        CommentCreationDTO dto = mapper.readValue(request.getInputStream(), CommentCreationDTO.class);
        if (commentService.createComment(dto.toDbObject())) {
            return "Success";
        }
        return "Failed";
    }

    private boolean isRightCookie(Cookie[] cookies) throws Exception {
        if (cookies == null || cookies.length == 0) {
            return false;
        }
        boolean isNeeded = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(EUSTRO_QR_COOKIE)) {
                if (cookie.getValue().equals(System.getenv(EUSTRO_QR_COOKIE)))
                    isNeeded = true;
            }
        }
        return isNeeded;
    }
}
