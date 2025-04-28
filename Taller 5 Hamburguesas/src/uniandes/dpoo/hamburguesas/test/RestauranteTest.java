package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;

class RestauranteTest {

    private Restaurante restaurante;

    @BeforeEach
    void setUp() {
        restaurante = new Restaurante();
    }

    @Test
    void testIniciarPedido() throws YaHayUnPedidoEnCursoException {
        restaurante.iniciarPedido("Cliente", "Dirección");
        assertNotNull(restaurante.getPedidoEnCurso());
    }

    @Test
    void testNoHayPedidoEnCursoException() {
        assertThrows(NoHayPedidoEnCursoException.class, () -> restaurante.cerrarYGuardarPedido());
    }

    @Test
    void testCargarInformacionRestaurante() {
        // Asumiendo que ya tienes archivos de prueba
        assertDoesNotThrow(() -> restaurante.cargarInformacionRestaurante(new File("ingredientes.txt"), new File("menu.txt"), new File("combos.txt")));
    }
}