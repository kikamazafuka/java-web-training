package by.training.module3.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    void create(T item);

    Optional<T> get(long id);

    void update(T item);

    void delete(long id);

    List<T> getAll();
}
