package org.jfcmc.spring.aop.rep;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public void publishComment(Comment comment) {
        System.out.println("Comment: " + comment);
    }
}
