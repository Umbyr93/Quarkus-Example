package it.urusso.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.urusso.model.entity.UserDao;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserDao> {
    public UserDao findByFiscalCode(String fiscalCode) {
        return find("fiscalCode", fiscalCode).firstResult();
    }
}
