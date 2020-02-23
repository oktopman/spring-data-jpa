package me.oktop.springdatajpa;

import me.oktop.springdatajpa.domain.custom.Post;
import me.oktop.springdatajpa.domain.custom.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Import(PostRepositoryTestConfig.class)
@DataJpaTest
@ExtendWith(SpringExtension.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

//    @Autowired
//    ApplicationContext applicationContext;

    @Test
    void 이벤트_퍼블리싱_테스트() {
        Post post = Post.builder()
                .title("event")
                .build();

        postRepository.save(post.publish());

//        PostPublishedEvent event = new PostPublishedEvent(post);
//        applicationContext.publishEvent(event);
    }

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
