package ifto.PWEB2Ecommerce.repository;

import ifto.PWEB2Ecommerce.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager em;

    public void save (Produto produto){
        em.persist(produto);
    }

    public Produto produto(Long id){
        return em.find(Produto.class, id);
    }

    public List<Produto> produtos(){
        Query query = em.createQuery("from Produto");
        return query.getResultList();
    }

    public List<Produto> produtosPorNome(String nome){
        Query query = em.createQuery("from Produto as produto where lower(produto.descricao) like lower(:nome)");
        // transformar a busca em CASE INSENSITIVE
        query.setParameter("nome","%"+nome+"%");
        return query.getResultList();
    }

    public void remove(Long id){
        Produto produto = em.find(Produto.class, id);
        em.remove(produto);
    }

    public void update(Produto produto){
        em.merge(produto);
    }
}
