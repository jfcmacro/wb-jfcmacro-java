package org.jfcmc.spring.aop.rep;

public class Comment {

    private String message;

    public Comment(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
