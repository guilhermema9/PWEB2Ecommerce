package ifto.PWEB2Ecommerce.repository;

import ifto.PWEB2Ecommerce.model.entity.Venda;
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
    public List<Venda> vendas(){
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }
}
