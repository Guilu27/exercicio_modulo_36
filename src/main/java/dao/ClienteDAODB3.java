package dao;

import dao.generics.GenericDAODB3;
import domain.Cliente;

public class ClienteDAODB3 extends GenericDAODB3<Cliente, Long> implements IClienteDAO {
    public ClienteDAODB3() {
        super(Cliente.class);
    }
}
