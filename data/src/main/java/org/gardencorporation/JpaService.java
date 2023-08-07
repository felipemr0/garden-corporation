package org.gardencorporation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.function.Function;

public final class JpaService {

    private static JpaService instance;
    private static EntityManagerFactory entityManagerFactory;

    private JpaService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-gardencorporation");
    }

    public static synchronized JpaService getInstance() {
        return (instance == null) ? instance = new JpaService() : instance;
    }

    public void close() {
        entityManagerFactory.close();
    }

    public <T> T runTransaction(Function<EntityManager, T> function) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        boolean success = false;

        try {
            T result = function.apply(entityManager);
            success = true;
            return result;
        } finally {
            if (success) {
                transaction.commit();
            } else {
                transaction.rollback();
            }
        }
    }

}
