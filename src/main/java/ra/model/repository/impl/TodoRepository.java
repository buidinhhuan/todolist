package ra.model.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.model.entity.Todo;
import ra.model.repository.ITodoRepository;
import javax.persistence.EntityManager;
import java.util.List;
@Component
public class TodoRepository implements ITodoRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Todo> findAll() {
        return entityManager.createQuery("SELECT T FROM Todo AS T").getResultList();
    }

    @Override
    public Todo findByID(Long id) {
        return entityManager.createQuery("SELECT T FROM Todo AS T WHERE T.id=:id", Todo.class)
                .setParameter("id", id)
                .getSingleResult();

    }

    @Override
    public void save(Todo p) {
        if (p.getId() == null) {
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }

    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findByID(id));
    }
}
