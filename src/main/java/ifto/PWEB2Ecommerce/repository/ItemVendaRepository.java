package ifto.PWEB2Ecommerce.repository;

import ifto.PWEB2Ecommerce.model.ItemVenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemVendaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<ItemVenda> itemVendas(){
        Query query = em.createQuery("from ItemVenda ");
        return query.getResultList();
    }

    public void remove(Long id){
        ItemVenda itemVenda = em.find(ItemVenda.class, id);
        em.remove(itemVenda);
    }
}
