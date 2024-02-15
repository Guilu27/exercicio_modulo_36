package dao.generics;

import domain.Persistente;

import java.io.Serializable;

public class GenericDAODB3<T extends Persistente, E extends Serializable>
        extends GenericDAO<T, E> {
    public GenericDAODB3(Class<T> persistenteClass) {
        super(persistenteClass, "MySQL");
    }
}
