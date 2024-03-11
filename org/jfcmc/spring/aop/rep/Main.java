package org.jfcmc.spring.aop.rep;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String...args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);

        System.out.println(service.getClass());
    }
}
