package data.access;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CardSetRepository {


    @PersistenceContext
    private EntityManager em;
}
