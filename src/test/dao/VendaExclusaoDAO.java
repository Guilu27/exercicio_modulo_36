package dao;

import dao.generics.GenericDAODB1;
import domain.Venda;

public class VendaExclusaoDAO extends GenericDAODB1<Venda, Long> implements IVendaDAO {
    public VendaExclusaoDAO() {
        super(Venda.class);
    }

    @Override
    public void finalizarVenda(Venda venda) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public void cancelarVenda(Venda venda) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public Venda consultarComCollection(Long id) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }
}
