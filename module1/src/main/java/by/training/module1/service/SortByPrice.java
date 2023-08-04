package by.training.module1.service;

import by.training.module1.entity.Tour;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class SortByPrice implements Comparator<Tour> {

    private static final Logger LOGGER = Logger.getLogger(TourOfferService.class);

    @Override
    public int compare(Tour h1, Tour h2) {

        LOGGER.info("Price compare");


        return Integer.compare(h1.getPrice(),h2.getPrice());

    }
}
