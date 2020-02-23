package me.oktop.springdatajpa.domain.custom;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Post extends AbstractAggregateRoot<Post> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Builder
    public Post(String title) {
        this.title = title;
    }


    public Post publish() {
        this.registerEvent(new PostPublishedEvent(this));
        return this;
    }
}
