package controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import publicApi.DTO.v1.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/")
public class CardController {

    @GetMapping("hello")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("card/{id}")
    public Card getCard(@PathVariable String id){
        System.out.println(id);
        return new Card();
    }
    
    @GetMapping("cards/{setName}")
    public List<Card> getAllBySetName(@PathVariable String setName){
        System.out.println(setName);
        return new ArrayList<>(Arrays.stream((new Card[]{new Card(), new Card()})).toList());
    }

}
