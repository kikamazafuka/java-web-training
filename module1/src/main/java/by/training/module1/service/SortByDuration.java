package by.training.module1.service;

import by.training.module1.entity.Tour;

import java.util.Comparator;
import java.util.List;

public class SortByDuration implements Comparator<Tour> {

    @Override
    public int compare(Tour h1, Tour h2) {

        return h1.getTourDuration()-h2.getTourDuration();


    }

    public  void  sortByDurationLiambda(List<Tour> tours){
        tours.sort((o1, o2) -> o1.getTourDuration()-o2.getTourDuration());
    }
}
