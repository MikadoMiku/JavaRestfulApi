package data.access;

import models.Card;
import org.springframework.stereotype.Repository;
import util.CardInfoGetter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CardRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Card insertCard(Card card){
        if(card.getId() == null){
            em.persist(card);
        }else{
            em.merge(card);
        }


        return card;
    }
}
