package me.oktop.springdatajpa;

import me.oktop.springdatajpa.domain.post.Comment;
import me.oktop.springdatajpa.domain.post.CommentRepository;
import me.oktop.springdatajpa.domain.post.Posts;
import me.oktop.springdatajpa.domain.post.PostsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostTest {

    @Autowired
    PostsRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Transactional
    @Test
    void crudRepository_테스트() {
        //given
        Posts post = Posts.builder()
                .title("hello spring boot common")
                .build();

        postRepository.save(post);

        //when
        Optional<Posts> post1 = postRepository.findById(1l);


        //then
        assertThat(post1.get().getTitle()).isEqualTo("hello spring boot common");
//        assertThat(post1).isEmpty();
//        post1.orElseThrow(() -> new IllegalArgumentException("asd"));
//        Post post2 = post1.orElseThrow(IllegalAccessError::new);

        //when
        Page<Posts> getPostPage = postRepository.findAll(PageRequest.of(0, 10));
        System.out.println("===============");
        System.out.println(getPostPage.getTotalElements());

//        then
        assertThat(getPostPage.getTotalElements()).isEqualTo(1);
        assertThat(getPostPage.getNumber()).isEqualTo(0);
        assertThat(getPostPage.getSize()).isEqualTo(10);
    }

    @Test
    void 옵셔널_테스트() throws IllegalAccessException {
        Optional<Posts> post = postRepository.findById(1l);
        System.out.println("==========");
//        post.orElseThrow(IllegalAccessException::new);

        // collection 은 null 이 나오지않는다~
        List<Posts> posts = postRepository.findAll();

//        if (post != null) {
//            throw new IllegalAccessException();
//        }
    }

    @Test
    @Transactional
    void JPA_메소드네이밍_연관관계_엔티티_테스트() {
        // given
        Posts post = Posts.builder()
                .title("jpa 테스트")
                .build();

        post.addComment(Comment.builder()
                .comment("댓글입니당")
                .build());
        postRepository.save(post);

        //when
        List<Posts> posts = postRepository.findByTitleContains("테스트");

        //then
        assertThat(posts.get(0).getTitle()).isEqualTo("jpa 테스트");
        System.out.println("===================");
        System.out.println(posts.get(0).toString());
        for (Comment temp : posts.get(0).getComments()) {
            System.out.println(temp.getComment());
        }
    }
}
