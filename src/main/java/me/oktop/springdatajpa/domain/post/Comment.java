package me.oktop.springdatajpa.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    private Posts post;

    public void setPost(Posts post) {
        this.post = post;
    }

    @Builder
    public Comment(String comment) {
        this.comment = comment;
    }
}
