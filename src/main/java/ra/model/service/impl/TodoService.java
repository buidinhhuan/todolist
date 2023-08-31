package ra.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Todo;
import ra.model.repository.ITodoRepository;
import ra.model.service.ITodoService;

import java.util.List;

@Service
public class TodoService implements ITodoService {
    @Autowired
    private ITodoRepository iTodoRepository;

    @Override
    public List<Todo> findAll() {
        return iTodoRepository.findAll();
    }

    @Override
    public Todo findByID(Long id) {
        return iTodoRepository.findByID(id);
    }

    @Override
    public void save(Todo p) {
        iTodoRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        iTodoRepository.delete(id);
    }
}
