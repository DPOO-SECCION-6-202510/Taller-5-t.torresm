package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;

class ProductoAjustadoTest {

    private ProductoMenu productoBase;
    private ProductoAjustado productoAjustado;

    @BeforeEach
    void setUp() {
        productoBase = new ProductoMenu("Hamburguesa", 7000);
        productoAjustado = new ProductoAjustado(productoBase);
    }

    @Test
    void testGetNombre() {
        assertEquals("Hamburguesa", productoAjustado.getNombre());
    }

    @Test
    void testGetPrecio() {
        assertEquals(7000, productoAjustado.getPrecio());
    }

    @Test
    void testGenerarTextoFactura() {
        String expected = "Hamburguesa\n";
        assertEquals(expected, productoAjustado.generarTextoFactura());
    }

    @Test
    void testAgregarIngrediente() {
        Ingrediente queso = new Ingrediente("Queso", 1000);
        productoAjustado.agregarIngrediente(queso);
        assertEquals(8000, productoAjustado.getPrecio());
    }

    @Test
    void testEliminarIngrediente() {
        Ingrediente queso = new Ingrediente("Queso", 1000);
        productoAjustado.agregarIngrediente(queso);
        productoAjustado.eliminarIngrediente(queso);
        assertEquals(7000, productoAjustado.getPrecio());
    }
}
