package by.training.module1.controller;

import by.training.module1.entity.Tour;
import by.training.module1.builder.TourBuilderFactory;
import by.training.module1.parser.DataReader;
import by.training.module1.parser.LineParser;
import by.training.module1.repository.TourRepository;
import by.training.module1.service.TourOfferService;
import by.training.module1.validator.FileValidator;
import by.training.module1.validator.TourValidatorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TourControllerTest {


    private TourController controller;


    @Before
    public void loadingInfo() throws IOException {
        TourRepository repository = new TourRepository();
        TourOfferService service = new TourOfferService(repository);
        FileValidator fileValidator = new FileValidator();
        DataReader input = new DataReader();
        LineParser parser = new LineParser();
        TourValidatorFactory validatorFactory = new TourValidatorFactory();
        TourBuilderFactory builderFactory = new TourBuilderFactory();
        controller= new TourController(service,fileValidator,input,parser,validatorFactory,builderFactory);
        controller.readFile(this.getClass().getClassLoader().getResource("tour.txt").getPath().substring(1));

    }

     @Test
     public void sortByPrice() {
         //Comparator<Tour> sortedTransportComparator = new SortByTransport();
         List<Tour> list = controller.sortByPrice();

         for(Tour t : list){
             System.out.println(t);
         }

         Assert.assertEquals(800, list.get(0).getPrice());
     }



    @Test
    public void readFile() {
    }

    @Test
    public void getTour() {
    }


}