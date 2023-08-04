package by.training.module1;

import by.training.module1.builder.ExcursionTourBuilder;
import by.training.module1.parser.DataReader;
import by.training.module1.validator.FileValidator;
import by.training.module1.parser.LineParser;
import by.training.module1.entity.*;
import by.training.module1.repository.TourRepository;
import by.training.module1.service.TourOfferService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FILE_NAME = "D:\\files\\Tours.txt";

    public static void main(String[] args) {

        Tour tour1 = new Tour(TourType.EXCURSION,12,Transport.BUS,Food.HALFBOARD,999);
        ExcursionTourBuilder ex = new ExcursionTourBuilder();
        Map <String, String> map = new HashMap<>();
        map.put("tourType","CRUISE");
        map.put("freeExcursion","true");
        map.put("duration","10");
        map.put("price","999");
        map.put("food","ALLINCLUSIVE");
        map.put("transport","BUS");
        map.put("excursionType","ACTIVE");
       Tour tour2 = ex.build(map);

  //      Tour tour1 = new ExcursionTour();
      /*  tour1.setFoodType(Food.ALLINCLUSIVE);
        tour1.setTransport(Transport.PLANE);
        tour1.setPrice(1254);
        tour1.setTourDuration(10);
        ((ExcursionTour) tour1).setExcursionType(ExcursionType.HISTORIC);
        ((ExcursionTour) tour1).setFreeExcursion(true);


        Tour tour2 = new ShoppingTour();
        tour2.setFoodType(Food.ALLINCLUSIVE);
        tour2.setTransport(Transport.BUS);
        tour2.setPrice(154);
        ((ShoppingTour) tour2).setDestanation("Minsk");


        Tour tour3 = new ExcursionTour();
        tour3.setFoodType(Food.ALLINCLUSIVE);
        tour3.setTransport(Transport.BUS);
        tour3.setPrice(12554);

        Tour tour4 = new ExcursionTour();
        tour4.setFoodType(Food.ALLINCLUSIVE);
        tour4.setTransport(Transport.BUS);
        tour4.setPrice(554);*/

       /* Tour tour5 = new Tour.Builder()
                .withTourDuration(6)
                .withFoodType(Food.HALFBOARD)
                .withPrice(800)
                .withTransport(Transport.CRUISELINER)
                .build();
*/

        TourOfferService offer1 = new TourOfferService(new TourRepository());

        offer1.addTour(tour1);
        offer1.addTour(tour2);
        /*offer1.addTour(tour3);
        offer1.addTour(tour4);
        offer1.addTour(tour5);

        System.out.println(offer1.getTours());*/

    /*    for (Tour t: offer1.getTours()) {
            System.out.println(t);
        }

        System.out.println();


        offer1.sortByPrice();

        for (Tour t: offer1.getTours()){
            System.out.println(t);
        }*/



       /* try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
            for(String line: lines){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("File not found "+e);
        }*/

        DataReader dataReader = new DataReader();
        FileValidator validator = new FileValidator();
        validator.validateFile(FILE_NAME);
        List<String> list = dataReader.getData(FILE_NAME);
        String line = list.get(0);
        LineParser lineParser = new LineParser();
        lineParser.parseLine(line);



    }

}
