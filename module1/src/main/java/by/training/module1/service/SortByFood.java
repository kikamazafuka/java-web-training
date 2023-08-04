package by.training.module1.service;

import by.training.module1.entity.Tour;


import java.util.Comparator;

public class SortByFood implements Comparator<Tour> {

    @Override
    public int compare(Tour h1, Tour h2) {

        return h1.getFoodType().compareTo(h2.getFoodType());
    }
}
