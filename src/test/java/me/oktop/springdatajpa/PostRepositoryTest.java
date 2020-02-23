package me.oktop.springdatajpa;

import me.oktop.springdatajpa.domain.custom.Post;
import me.oktop.springdatajpa.domain.custom.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Transactional
    void crud() {
        Post post = Post.builder()
                .title("하이버네이트")
                .build();
        assertThat(postRepository.isContains(post)).isFalse();
        postRepository.save(post);

        assertThat(postRepository.isContains(post)).isTrue();
//        postRepository.findByPost();
        postRepository.delete(post);
        postRepository.flush();
    }
}
