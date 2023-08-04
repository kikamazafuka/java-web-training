package by.training.module1.repository;

import by.training.module1.entity.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourRepository implements Repository<Tour> {

    private List<Tour> tours;

    public TourRepository() {
        this.tours = new ArrayList<>();
    }

    public TourRepository(List<Tour> tours) {
        this.tours = new ArrayList<>();
    }

    @Override
    public void add(Tour item) {
        tours.add(item);

    }

    @Override
    public void remove(Tour item) {
        tours.remove(item);

    }

    @Override
    public List<Tour> getAll() {
        return new ArrayList<>(tours);
    }

    @Override
    public List<Tour> findBy(Specification<Tour> spec) {


        List<Tour> found = new ArrayList<>();

        for (Tour tour : tours) {
            if (spec.isSatisfiedBy(tour)) {
                found.add(tour);
            }
        }
            return found;
    }
}



