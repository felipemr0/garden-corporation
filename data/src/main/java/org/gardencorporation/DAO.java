package org.gardencorporation;

import java.util.List;

//TODO 
public class DAO<T> {

    private JpaService jpaService;

    public DAO() {
        jpaService = JpaService.getInstance();
    }

    public <T> void create(T entity) {
        jpaService.runTransaction((entityManager) -> {
            entityManager.persist(entity);
            return null;
        });
    }

    public T update(T entity) {
        return jpaService.runTransaction((entityManager) -> {
            return entityManager.merge(entity);
        });
    }

    public List<T> getAll(Class<T> resultClass) {
        List<T> list = List.of();

        list = jpaService.runTransaction((entityManager) -> {
            return entityManager.createQuery("FROM " + resultClass.getName(), resultClass).getResultList();
        });

        return list;
    }
}
