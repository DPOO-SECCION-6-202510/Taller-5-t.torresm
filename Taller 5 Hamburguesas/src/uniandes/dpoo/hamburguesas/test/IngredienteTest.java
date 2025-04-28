package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;

class IngredienteTest {

    private Ingrediente ingrediente;

    @BeforeEach
    void setUp() {
        ingrediente = new Ingrediente("Queso", 1000);
    }

    @Test
    void testGetNombre() {
        assertEquals("Queso", ingrediente.getNombre());
    }

    @Test
    void testGetCostoAdicional() {
        assertEquals(1000, ingrediente.getCostoAdicional());
    }
}