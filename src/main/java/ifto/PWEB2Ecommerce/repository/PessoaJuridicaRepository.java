package ifto.PWEB2Ecommerce.repository;

import ifto.PWEB2Ecommerce.model.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaJuridicaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save (PessoaJuridica pessoaJuridica){
        em.persist(pessoaJuridica);
    }

    public PessoaJuridica pessoaJuridica(Long id){
        return em.find(PessoaJuridica.class,id);
    }

    public List<PessoaJuridica> pessoasJuridicas(){
        Query query = em.createQuery("from PessoaJuridica ");
        return query.getResultList();
    }

    public void remove(Long id){
        PessoaJuridica pessoaJuridica = em.find(PessoaJuridica.class, id);
        em.remove(pessoaJuridica);
    }

    public void update(PessoaJuridica pessoaJuridica){
        em.merge(pessoaJuridica);
    }
}
