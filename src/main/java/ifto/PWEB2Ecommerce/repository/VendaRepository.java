package ifto.PWEB2Ecommerce.repository;

import ifto.PWEB2Ecommerce.model.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendaRepository {

    @PersistenceContext
    private EntityManager em;

    public Venda venda(Long id){
        return em.find(Venda.class, id);
    }

    public void save (Venda venda){
        em.persist(venda);
    }

    public List<Venda> vendas(){
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }

    public void remove(Long id){
        Venda venda = em.find(Venda.class, id);
        em.remove(venda);
    }

    public void update(Venda venda){
        em.merge(venda);
    }
}
