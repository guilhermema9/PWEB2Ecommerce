package ifto.PWEB2Ecommerce.repository;

import ifto.PWEB2Ecommerce.model.Endereco;
import ifto.PWEB2Ecommerce.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnderecoRepository {

    @PersistenceContext
    private EntityManager em;

    public Endereco endereco(Long id){
        return em.find(Endereco.class, id);
    }

    public List<Endereco> enderecos(){
        Query query = em.createQuery("from Endereco");
        return query.getResultList();
    }

    public void save(Endereco endereco){
        em.persist(endereco);
    }

    public void remove(Long id){
        Endereco endereco = em.find(Endereco.class, id);
        em.remove(endereco);
    }

    public void update(Endereco endereco){
        em.merge(endereco);
    }
}
