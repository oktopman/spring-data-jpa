package me.oktop.springdatajpa.domain.custom;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findByPost();

    void delete(T entity);
}
