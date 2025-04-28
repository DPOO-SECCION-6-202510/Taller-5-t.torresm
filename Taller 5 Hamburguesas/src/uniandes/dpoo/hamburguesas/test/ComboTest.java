package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class ComboTest {

    private Combo combo;

    @BeforeEach
    void setUp() {
        ArrayList<ProductoMenu> productos = new ArrayList<>();
        productos.add(new ProductoMenu("Hamburguesa", 7000));
        productos.add(new ProductoMenu("Papas", 3000));
        combo = new Combo("Combo Sencillo", 0.9, productos);
    }

    @Test
    void testGetNombre() {
        assertEquals("Combo Sencillo", combo.getNombre());
    }

    @Test
    void testGetPrecio() {
        assertEquals(9000, combo.getPrecio());
    }

    @Test
    void testGenerarTextoFactura() {
        String expected = "Combo Combo Sencillo\n Descuento: 0.9\n            9000\n";
        assertEquals(expected, combo.generarTextoFactura());
    }
}
