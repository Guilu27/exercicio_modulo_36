package dao.generics;

import domain.Persistente;

import java.io.Serializable;

public class GenericDAODB1<T extends Persistente, E extends Serializable>
        extends GenericDAO<T, E> {
    public GenericDAODB1(Class<T> persistenteClass) {
        super(persistenteClass, "Postgre1");
    }
}
