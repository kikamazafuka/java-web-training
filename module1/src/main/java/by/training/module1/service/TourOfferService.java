package by.training.module1.service;

import by.training.module1.entity.Tour;
import by.training.module1.repository.TourRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class TourOfferService {

    private TourRepository tours;


    public TourOfferService(TourRepository tours) {
        this.tours = tours;
    }

    public List<Tour> getTours() {
        return this.tours.getAll();
    }

    public void addTour(Tour tour){
        this.tours.add(tour);
    }

   /* public List<Tour> sortByFood(){
        SortByFood comparator = new SortByFood();
        tours.sort(comparator);

        return tours;
    }*/

    public List<Tour> sortBy(Comparator<Tour> comparator){
        List<Tour> sortedTours = tours.getAll();
        sortedTours.sort(comparator);
        return sortedTours;
    }



   /* public List<Tour> sortByPrice() {
        SortByPrice comparator = new SortByPrice();
        tours.sort(comparator);

        return tours;
    }

    public List<Tour> sortByDuration() {
        SortByDuration comparator = new SortByDuration();
        tours.sort(comparator);

        return tours;
    }

    public List<Tour> sortByParam() {
        Comparator<Tour> personComparator = new SortByFood()
                .thenComparing(new SortByTransport())
                .thenComparing(new SortByDuration());
        tours.sort(personComparator);
        return tours;
    }*/

}
