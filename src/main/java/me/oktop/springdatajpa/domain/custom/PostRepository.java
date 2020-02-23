package me.oktop.springdatajpa.domain.custom;

import me.oktop.springdatajpa.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository<Post>, MyRepository<Post, Long> {
}
