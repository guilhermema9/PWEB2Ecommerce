package ifto.PWEB2Ecommerce.repository;

import ifto.PWEB2Ecommerce.model.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {

    @PersistenceContext
    private EntityManager em;

    public Role role(String role){
        try {
            String jpql = "from Role r where r.nome = :role";
            TypedQuery<Role> query = em.createQuery(jpql, Role.class);
            query.setParameter("role", role);
            return query.getSingleResult();
        } catch (NoResultException nre){
            return null;
        }
    }
}
