package services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import models.Card;
import models.CardSetInfo;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.contracts.ICardRepo;
import service.contracts.ICardService;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CardService implements ICardService {

    private final ICardRepo cardRepository;
    //private final ICardSetInfoRepo cardSetInfoRepository;


    @Override
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public <T> Card updateCardField(Long id, String fieldName, T newFieldValue) {
        Card dbCard = cardRepository.getById(id);

        try {
            Field field = dbCard.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(dbCard, newFieldValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(Arrays.toString(e.getStackTrace()));
        }
        return cardRepository.save(dbCard);
    }

    @Override
    public void deleteCardById(Long id) {
        cardRepository.deleteById(id);
    }

    @Override
    public Card getCardById(Long id) {
        /*List<CardSetInfo> setInfo = card.getCard_sets();*/
        //Hibernate.initialize(card.getCard_sets());
        return cardRepository.findById(id).get();
    }

    @Override
    public Card getCardByName(String name) {
        return cardRepository.getCardByName(name);
    }
}
