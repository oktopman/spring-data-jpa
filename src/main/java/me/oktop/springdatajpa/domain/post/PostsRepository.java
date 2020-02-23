package me.oktop.springdatajpa.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findByTitleContains(String title);
}
