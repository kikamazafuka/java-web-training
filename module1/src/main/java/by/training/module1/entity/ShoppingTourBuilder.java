package by.training.module1.entity;

import org.apache.log4j.Logger;

import java.util.Map;

public class ShoppingTourBuilder implements Builder {
    private Logger LOGGER = Logger.getLogger(ExcursionTourBuilder.class);

    @Override
    public ExcursionTour build(Map<String, String> tourBuild) {

        ExcursionTour tour;

        TourType tourType = TourType.valueOf(tourBuild.get("type").toUpperCase());
        boolean freeExcursion = Boolean.parseBoolean("freeExcursion");
        int tourDuration = Integer.parseInt(tourBuild.get("duration"));
        int price = Integer.parseInt(tourBuild.get("price"));
        Food food = Food.valueOf(tourBuild.get("food").toUpperCase());
        Transport transport = Transport.valueOf(tourBuild.get("transport").toUpperCase());
        ExcursionType excursionType = ExcursionType.valueOf(tourBuild.get("excursionType").toUpperCase());

        tour = new ExcursionTour(tourType, tourDuration, transport, food, freeExcursion, excursionType, price);

        LOGGER.info("Tour has been built " + tour);

        return tour;
    }
}
