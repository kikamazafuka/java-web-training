package by.training.module2.repository;

public interface Specification<T> {
    boolean isSatisfiedBy(T entity);

    default Specification<T> and(Specification<T> other) {
        Specification<T> self = this;
        return new Specification<T>() {
            @Override
            public boolean isSatisfiedBy(T entity) {
                return self.isSatisfiedBy(entity)
                        && other.isSatisfiedBy(entity);
            }
        };
    }

    default Specification<T> or(Specification<T> other) {
        Specification<T> self = this;
        return new Specification<T>() {
            @Override
            public boolean isSatisfiedBy(T entity) {
                return self.isSatisfiedBy(entity)
                        || other.isSatisfiedBy(entity);
            }
        };
    }

    default Specification<T> not(Specification<T> other) {
        Specification<T> self = this;
        return new Specification<T>() {
            @Override
            public boolean isSatisfiedBy(T entity) {
                return self.isSatisfiedBy(entity)
                        != other.isSatisfiedBy(entity);
            }
        };
    }
}
