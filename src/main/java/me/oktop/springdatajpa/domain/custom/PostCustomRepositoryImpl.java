package me.oktop.springdatajpa.domain.custom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Repository
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final EntityManager entityManager;

    /*
    * 기능을 추가하는 커스텀
    * */
    @Override
    public List<Post> findByPost() {
        System.out.println("custom findMyPost........");
        return entityManager.createQuery("select p from Post AS p", Post.class)
                .getResultList();
    }

    @Override
    public void delete(Object entity) {
        System.out.println("custom delete");
        entityManager.remove(entity);
    }
}

