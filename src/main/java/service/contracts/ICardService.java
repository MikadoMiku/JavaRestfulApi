package service.contracts;

import models.Card;

public interface ICardService {
    Card saveCard(Card card);
    <T> Card updateCardField(Long id, String fieldName, T newFieldValue);
    void deleteCardById(Long id);
    Card getCardById(Long id);
    Card getCardByName(String name);
}
