package util;

import models.Card;

import java.io.*;
import java.net.URL;


public class ImagePuller {

    public static void pullImages(CardInfoGetter.Data cardData) {
        for (Card card : cardData.getData()) {
            try (BufferedInputStream in = new BufferedInputStream(new URL(card.getCard_images().get(0).getImage_url()).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(String.format("C:/Users/power/IdeaProjects/JavaRestfulApi/images/%s.jpg", card.getFileCode()))) {
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

