package ifto.PWEB2Ecommerce.repository;

import ifto.PWEB2Ecommerce.model.PessoaFisica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaFisicaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save (PessoaFisica pessoaFisica){
        em.persist(pessoaFisica);
    }

    public PessoaFisica pessoaFisica(Long id){
        return em.find(PessoaFisica.class,id);
    }

    public List<PessoaFisica> pessoasFisicas(){
        Query query = em.createQuery("from PessoaFisica ");
        return query.getResultList();
    }

    public void remove(Long id){
        PessoaFisica pessoaFisica = em.find(PessoaFisica.class, id);
        em.remove(pessoaFisica);
    }

    public void update(PessoaFisica pessoaFisica){
        em.merge(pessoaFisica);
    }
}
