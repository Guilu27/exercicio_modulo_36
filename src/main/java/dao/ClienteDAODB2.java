package dao;

import dao.generics.GenericDAODB2;
import domain.Cliente;

public class ClienteDAODB2 extends GenericDAODB2<Cliente, Long> implements IClienteDAO {
    public ClienteDAODB2() {
        super(Cliente.class);
    }
}
