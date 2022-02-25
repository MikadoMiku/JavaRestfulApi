package util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Config;
import config.HsqlDataSource;
import data.access.CardRepository;
import models.Card;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Component
public class DbDataPopulator {

    public static void main(String[] args){
        DbDataPopulator dPop = new DbDataPopulator();
        dPop.populateDatabaseWithCardData();
    }

    public void populateDatabaseWithCardData(){
        System.out.println("STARTING POPULATING DATABASE WITH CARD DATA...");

        var ctx = new AnnotationConfigApplicationContext(Config.class, HsqlDataSource.class);
        CardRepository cardRepository = ctx.getBean(CardRepository.class);

        String fileContent = "";

        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/power/IdeaProjects/JavaRestfulApi/cardData.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while(line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            fileContent = sb.toString();


            ObjectMapper ob = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            CardInfoGetter.Data data = ob.readValue(fileContent, CardInfoGetter.Data.class);


            /*System.out.println(fileContent);
            System.out.println(data.getData().get(2).getAtk());
            System.out.println(data.getData().get(2).getAttribute());
            System.out.println(data.getData().get(2).getName());*/

            for (Card cardData: data.getData()) {
                cardRepository.insertCard(cardData);
            }

        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }

        System.out.println("FINISHED POPULATING DATABASE WITH CARD DATA!");
    }

}
