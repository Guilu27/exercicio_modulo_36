package dao;

import dao.generics.GenericDAODB1;
import domain.Cliente;

public class ClienteDAODB1 extends GenericDAODB1<Cliente, Long> implements IClienteDAO {
    public ClienteDAODB1() {
        super(Cliente.class);
    }
}
