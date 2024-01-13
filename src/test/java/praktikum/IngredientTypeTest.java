package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testIngredientType() {
        for (IngredientType type : IngredientType.values()) {
            assertNotNull(type);
        }
    }

    @Test
    public void testSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void testFilling() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }

    @Test
    public void testValueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}