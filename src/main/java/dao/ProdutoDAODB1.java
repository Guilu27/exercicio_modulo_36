package dao;

import dao.generics.GenericDAODB1;
import domain.Produto;

public class ProdutoDAODB1 extends GenericDAODB1<Produto, Long> implements IProdutoDAO {
    public ProdutoDAODB1() {
        super(Produto.class);
    }
}
