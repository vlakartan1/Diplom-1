package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;

    @Test
    public void getNameTest() {
        ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 20f);
        assertEquals("sour cream", ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 30f);
        assertEquals(30f, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void getTypeTest() {
        ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 50f);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
