package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;

class PedidoTest {

    private Pedido pedido;
    private ProductoMenu producto;

    @BeforeEach
    void setUp() {
        pedido = new Pedido("Cliente", "Dirección");
        producto = new ProductoMenu("Hamburguesa", 7000);
    }

    @Test
    void testGetIdPedido() {
        assertEquals(0, pedido.getIdPedido());
    }

    @Test
    void testGenerarTextoFactura() {
        pedido.agregarProducto(producto);
        String expected = "Cliente: Cliente\nDirección: Dirección\n----------------\nHamburguesa\n            7000\n----------------\nPrecio Neto:  7000\nIVA:          1330\nPrecio Total: 8330\n";
        assertEquals(expected, pedido.generarTextoFactura());
    }

    @Test
    void testGuardarFactura() throws FileNotFoundException {
        pedido.agregarProducto(producto);
        File archivo = new File("factura_0.txt");
        pedido.guardarFactura(archivo);
        assertTrue(archivo.exists());
    }

    @Test
    void testAgregarProducto() {
        pedido.agregarProducto(producto);
        assertEquals(1, pedido.getProductos().size());
    }

    @Test
    void testNoHayPedidoEnCursoException() {
        assertThrows(NoHayPedidoEnCursoException.class, () -> pedido.guardarFactura(new File("factura.txt")));
    }
}