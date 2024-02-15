package main;

import dao.ClienteDAODB1;
import dao.ClienteDAODB2;
import dao.IClienteDAO;
import domain.Cliente;
import exceptions.DAOException;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class ClienteDAO2BancosTest {
    private IClienteDAO iClienteDAODB1;
    private IClienteDAO iClienteDAODB2;
    private Random rd;

    public ClienteDAO2BancosTest() {
        iClienteDAODB1 = new ClienteDAODB1();
        iClienteDAODB2 = new ClienteDAODB2();
        rd = new Random();
    }

    public void testarCadastroPesquisaExclusao(Cliente cliente, IClienteDAO iClienteDAO) throws DAOException {
        Cliente clienteCadastrado = iClienteDAO.cadastrar(cliente);
        assertNotNull(clienteCadastrado);
        assertNotNull(clienteCadastrado.getId());

        Cliente clientePesquisado = iClienteDAO.pesquisar(cliente.getId());
        assertNotNull(clientePesquisado);
        assertEquals(cliente.getCpf(), clientePesquisado.getCpf());

        iClienteDAO.excluir(clienteCadastrado);
        Cliente produtoExcluido = iClienteDAO.pesquisar(clienteCadastrado.getId());
        assertNull(produtoExcluido);
    }

    @Test
    public void CadastroPesquisaExclusao() throws DAOException {
        Cliente clienteDB1 = criarCliente();
        Cliente clienteDB2 = criarCliente();

        testarCadastroPesquisaExclusao(clienteDB1, iClienteDAODB1);
        testarCadastroPesquisaExclusao(clienteDB2, iClienteDAODB2);
    }

    public void testarAlterar(Cliente cliente, IClienteDAO iClienteDAO) throws DAOException {
        Cliente clienteCadastrado = iClienteDAO.cadastrar(cliente);
        assertNotNull(clienteCadastrado);
        assertNotNull(clienteCadastrado.getId());

        Cliente clientePesquisado = iClienteDAO.pesquisar(cliente.getId());
        assertNotNull(clientePesquisado);
        assertEquals(cliente.getCpf(), clientePesquisado.getCpf());

        clienteCadastrado.setNome("Outro Cliente");
        iClienteDAO.alterar(clienteCadastrado);
        Cliente clienteAlterado = iClienteDAO.pesquisar(clienteCadastrado.getId());
        assertNotNull(clienteAlterado);
        assertEquals(clienteCadastrado.getNome(), clienteAlterado.getNome());

        iClienteDAO.excluir(clienteCadastrado);
        Cliente produtoExcluido = iClienteDAO.pesquisar(clienteCadastrado.getId());
        assertNull(produtoExcluido);
    }

    @Test
    public void alterar() throws DAOException {
        Cliente clienteDB1 = criarCliente();
        Cliente clienteDB2 = criarCliente();

        testarAlterar(clienteDB1, iClienteDAODB1);
        testarAlterar(clienteDB2, iClienteDAODB2);
    }

    public void testarPesquisarTodos(Cliente cliente1, Cliente cliente2, IClienteDAO iClienteDAO) throws DAOException {
        Cliente clienteCadastrado1 = iClienteDAO.cadastrar(cliente1);
        assertNotNull(clienteCadastrado1);
        assertNotNull(clienteCadastrado1.getId());

        Cliente clienteCadastrado2 = iClienteDAO.cadastrar(cliente2);
        assertNotNull(clienteCadastrado2);
        assertNotNull(clienteCadastrado2.getId());

        List<Cliente> list = iClienteDAO.pesquisarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        for (Cliente cliente : list) {
            iClienteDAO.excluir(cliente);
            Cliente clienteExcluido = iClienteDAO.pesquisar(cliente.getId());
            assertNull(clienteExcluido);
        }
    }

    @Test
    public void pesquisarTodos() throws DAOException {
        Cliente cliente1DB1 = criarCliente();
        Cliente cliente2DB1 = criarCliente();

        testarPesquisarTodos(cliente1DB1, cliente2DB1, iClienteDAODB1);

        Cliente cliente1DB2 = criarCliente();
        Cliente cliente2DB2 = criarCliente();
        testarPesquisarTodos(cliente1DB2, cliente2DB2, iClienteDAODB2);
    }


    private Cliente criarCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Cliente 1");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        return cliente;
    }
}
