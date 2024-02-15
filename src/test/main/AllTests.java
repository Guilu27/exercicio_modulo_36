package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ClienteDAODB1Test.class,
        ProdutoDAODB1Test.class,
        VendaDAODB1Test.class,
        ClienteDAO2BancosTest.class,
        ClienteDAO3BancosTest.class})
public class AllTests {

}