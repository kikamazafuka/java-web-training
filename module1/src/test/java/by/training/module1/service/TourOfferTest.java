package by.training.module1.service;

import by.training.module1.repository.TourRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import by.training.module1.entity.*;

import java.util.Comparator;
import java.util.List;

import static by.training.module1.entity.Transport.*;

import static by.training.module1.entity.Food.*;
import static org.junit.Assert.assertTrue;


public class TourOfferTest {

   /* private static final Tour TOUR = new Tour.Builder()
            .withTourDuration(6)
            .withFoodType(Food.HALFBOARD)
            .withPrice(800)
            .withTransport(Transport.CRUISELINER)
            .build();*/

    private static final Tour TOUR_EXCURSION = new ExcursionTour(TourType.EXCURSION, 5,
            Transport.BUS,
            Food.HALFBOARD,
            true,
            ExcursionType.HISTORIC,
            1500);


    private TourOfferService offer;

    @Before

    public void loadingInfo() {
        offer = new TourOfferService(new TourRepository());
        offer.addTour(new Tour(TourType.CRUISE,6, PLANE, HALFBOARD,800));
        offer.addTour(new Tour(TourType.EXCURSION,15,BUS, HALFBOARD,700));
        offer.addTour(new Tour(TourType.EXCURSION,6, PLANE, HALFBOARD,800));
        offer.addTour(new Tour(TourType.CRUISE,15,BUS, HALFBOARD,700));



        /*Tour tour1 = new Tour.Builder()
                .withTourDuration(6)
                .withFoodType(Food.HALFBOARD)
                .withPrice(800)
                .withTransport(Transport.CRUISELINER)
                .build();*/

        Tour tour2 = new ExcursionTour(TourType.EXCURSION,5,
                Transport.BUS,
                Food.HALFBOARD,
                true,
                ExcursionType.HISTORIC,
                1500);

        //offer.addTour(tour1);
        offer.addTour(tour2);


    }



    @Test
    public void sortByPrice() {
        Comparator<Tour> sortedPriceComparator = new SortByPrice();
        List<Tour> list = offer.sortBy(sortedPriceComparator);

        for(Tour t : list){
            System.out.println(t);
        }

        Assert.assertEquals(800, list.get(2).getPrice());
    }

    @Test
    public void sortByTransport() {
        Comparator<Tour> sortedTransportComparator = new SortByTransport();
        List<Tour> list = offer.sortBy(sortedTransportComparator);

        for(Tour t : list){
            System.out.println(t);
        }

        Assert.assertEquals(PLANE, list.get(0).getTransport());
    }


    /*@After
    public void outputInfo() {


        for (TourRepository tour : offer.getTours()) {
            System.out.println(tour);
        }
    }*/

    @Test
    public void addTour() {
    }


}