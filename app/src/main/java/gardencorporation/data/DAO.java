package data;

import java.util.List;

public interface DAO<T> {
    
    void add(T t);
    List<T> getAll();
    
}
