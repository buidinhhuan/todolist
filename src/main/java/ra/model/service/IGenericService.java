package ra.model.service;

import java.util.ArrayList;
import java.util.List;

public interface IGenericService <T,E>{
    List<T> findAll();
    T findByID(E id);
    void save(T p);
    void delete(E id);

}
