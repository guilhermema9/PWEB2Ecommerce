package ifto.PWEB2Ecommerce.repository;

import ifto.PWEB2Ecommerce.model.entity.ItemVenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class ItemVendaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<ItemVenda> itemVendas(){
        Query query = em.createQuery("from ItemVenda ");
        return query.getResultList();
    }
}
