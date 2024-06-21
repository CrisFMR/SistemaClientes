package cl.praxis.module;

import cl.praxis.module.modelo.CategoriaEnum;
import cl.praxis.module.modelo.Cliente;
import cl.praxis.module.servicio.ClienteServicio;
import org.junit.jupiter.api.*;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Clase test ClienteServicios")
public class ClienteServicioTest {
    private static ClienteServicio clienteServicio = new ClienteServicio();
    private static Logger logger = Logger.getLogger("cl.praxis.module");

    @BeforeAll
    static void setUp() {
        clienteServicio = new ClienteServicio();
        logger = Logger.getLogger("cl.praxis.module");
        logger.info("clase test ClienteServicioTest");

    }

    @BeforeEach
    void init() {
        logger.info("Iniciando metodo de prueba");

    }

    @AfterAll
    static void finish() {
        logger.info("Terminando clase test ServicioPersonaTest");

    }

    @AfterEach
    void done() {
        logger.info("Terminando metodo de prueba");

    }


    @Test
    public void agregarClienteTest() {
        logger.info("Iniciando metodo de prueba agregarClienteTest en la clase ClienteServicioTest");
        Cliente cliente = new Cliente("27-0", "Fulanito", "Perez", "2", CategoriaEnum.ACTIVO);
        clienteServicio.agregarCliente(cliente);
        assertEquals(1, clienteServicio.getListaClientes().size());

    }
}
