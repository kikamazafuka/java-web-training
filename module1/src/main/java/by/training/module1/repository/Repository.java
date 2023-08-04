package by.training.module1.repository;

import java.util.List;


    public interface Repository<T> {

        void add(T item);

        void remove(T item);

        List<T> getAll();

        List<T> findBy(Specification<T> spec);

    }
