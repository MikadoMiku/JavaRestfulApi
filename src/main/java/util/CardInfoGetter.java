package util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Card;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardInfoGetter {

    public static void main(String[] args) {
        ObjectMapper ob = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Data cardList;
        HttpURLConnection conn = null;
        try {
            URL url = new URL("https://db.ygoprodeck.com/api/v7/cardinfo.php?cardset=Lightning%20Overdrive");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            // Maybe check if status ok?
            int status = conn.getResponseCode();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String readData = reader.lines().collect(Collectors.joining("\n"));

            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/power/IdeaProjects/JavaRestfulApi/cardData.txt"));

            writer.write(readData);

            writer.close();

            //cardList = (ob.readValue(readData, Data.class));

            reader.close();

        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally{
            if(conn != null){
                conn.disconnect();
            }
        }

        /*if(cardList != null){
            DbDataPopulator dbPopulate = new DbDataPopulator();
            dbPopulate.populateDatabaseWithCardData(cardList);
            //pull all images naming them the UUID of the card fileCode
            //ImagePuller.pullImages(cardList);
        }*/

    }

    @lombok.Data
    public static class Data {
        List<Card> data = new ArrayList<>();
    }
}
