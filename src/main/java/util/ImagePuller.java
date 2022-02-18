package util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Card;

import java.io.*;
import java.net.URL;
import java.util.Arrays;


public class ImagePuller {

    public static void main(String[] args){
        pullImages();
    }

    public static void pullImages() {
        CardInfoGetter.Data cardData;
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try(BufferedReader input = new BufferedReader(new FileReader("cardData.txt"))) {
            StringBuilder sb = new StringBuilder();

            String line = input.readLine();

            while(line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = input.readLine();
            }

            cardData = objectMapper.readValue(sb.toString(), CardInfoGetter.Data.class);

        }catch (IOException e){
            throw new RuntimeException(Arrays.toString(e.getStackTrace()));
        }

        for (Card card : cardData.getData()) {
            try (BufferedInputStream in = new BufferedInputStream(new URL(card.getCard_images().get(0).getImage_url()).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(String.format("C:/Users/power/IdeaProjects/JavaRestfulApi/images/%s.jpg", card.getName()))) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;

                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }

            } catch (IOException e) {
                // handle exception
            }
        }
    }
}

