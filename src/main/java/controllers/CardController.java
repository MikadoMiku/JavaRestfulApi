package controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import publicApi.DTO.v1.Card;
import service.contracts.ICardService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final ICardService cardService;
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @GetMapping("hello")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("card/{id}")
    public Card getCardById(@PathVariable Long id){
        Card card;
        try{
            models.Card cardModel = cardService.getCardById(id);
            String json = objectMapper.writeValueAsString(cardModel);
            card = objectMapper.readValue(json, Card.class);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e.getOriginalMessage());
        }
        return card;
    }
    
    @GetMapping("cards/{setName}")
    public List<Card> getAllBySetName(@PathVariable String setName){
        System.out.println(setName);
        return new ArrayList<>(Arrays.stream((new Card[]{new Card(), new Card()})).toList());
    }

}
