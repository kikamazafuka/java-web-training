package by.training.module1.builder;

import by.training.module1.entity.Food;
import by.training.module1.entity.ShoppingTour;
import by.training.module1.entity.TourType;
import by.training.module1.entity.Transport;
import org.apache.log4j.Logger;

import java.util.Map;

public class ShoppingTourBuilder implements Builder {
    private Logger LOGGER = Logger.getLogger(ExcursionTourBuilder.class);

    @Override
    public ShoppingTour build(Map<String, String> tourBuild) {


        TourType tourType = TourType.valueOf(tourBuild.get("type").toUpperCase());
        int tourDuration = Integer.parseInt(tourBuild.get("duration"));
        int price = Integer.parseInt(tourBuild.get("price"));
        Food food = Food.valueOf(tourBuild.get("food").toUpperCase());
        String destanation = String.valueOf(tourBuild.get("destanation"));
        Transport transport = Transport.valueOf(tourBuild.get("transport").toUpperCase());

        ShoppingTour tour = new ShoppingTour(tourType, tourDuration, transport, food, price, destanation);

        LOGGER.info("Tour has been built " + tour);

        return tour;
    }
}
