package me.oktop.springdatajpa.domain.custom;


import org.springframework.context.ApplicationEvent;

public class PostPublishedEvent extends ApplicationEvent { // 전달하고자 하는 이벤트. ApplicationEvent 를 상속받아 구현

    private final Post post;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PostPublishedEvent(Object source) {
        super(source);
        this.post = (Post) source;
    }

    public Post getPost() {
        return post;
    }


}
