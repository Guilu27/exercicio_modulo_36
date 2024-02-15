package dao.generics;

import domain.Persistente;

import java.io.Serializable;

public class GenericDAODB2<T extends Persistente, E extends Serializable>
        extends GenericDAO<T, E> {
    public GenericDAODB2(Class<T> persistenteClass) {
        super(persistenteClass, "Postgre2");
    }
}
