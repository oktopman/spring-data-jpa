package me.oktop.springdatajpa.domain.custom;

import org.springframework.context.event.EventListener;

public class PostListener {

    @EventListener
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("================");
        System.out.println(event.getPost().getTitle() + "is published!!");
        System.out.println("================");
    }
}
