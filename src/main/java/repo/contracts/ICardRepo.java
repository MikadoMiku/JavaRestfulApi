package repo.contracts;

import models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardRepo extends JpaRepository<Card, Long> {
    Card getCardByName(String name);
}
