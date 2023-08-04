package by.training.module1.builder;

import by.training.module1.entity.*;
import org.apache.log4j.Logger;

import java.util.Map;

public class CruiseTourBuilder implements Builder {
    private Logger LOGGER = Logger.getLogger(CruiseTourBuilder.class);

    @Override
    public CruiseTour build(Map<String, String> tourBuild) {


       TourType tourType = TourType.valueOf(tourBuild.get("tourType"));
        int tourDuration = Integer.parseInt(tourBuild.get("duration"));
        int price = Integer.parseInt(tourBuild.get("price"));
        Food food = Food.valueOf(tourBuild.get("food").toUpperCase());
        Transport transport = Transport.valueOf(tourBuild.get("transport").toUpperCase());
        BoatType boatType = BoatType.valueOf(tourBuild.get("boatType").toUpperCase());

        CruiseTour tour = new CruiseTour(tourType, tourDuration, transport, food, price, boatType);

        LOGGER.info("Tour has been built " + tour);

        return tour;
    }
}
