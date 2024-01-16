package praktikum;

import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BurgerTest {
    private final Burger burger = new Burger();
    private final Bun bun = mock(Bun.class);
    public List<Ingredient> ingredients = new ArrayList<>();
    private final Ingredient ingredient = mock(Ingredient.class);
    private final Ingredient ingredientFirst = mock(Ingredient.class);
    private final Ingredient ingredientSecond = mock(Ingredient.class);


    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertSame(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0, 1);

        assertEquals(ingredientFirst, burger.ingredients.get(1));
        assertEquals(ingredientSecond, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        when(ingredientFirst.getPrice()).thenReturn(20f);
        when(ingredientSecond.getPrice()).thenReturn(5f);
        ingredients.add(ingredientFirst);
        ingredients.add(ingredientSecond);


        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);

        float expectedPrice = 2 * bun.getPrice() + ingredientFirst.getPrice() + ingredientSecond.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.01f);
    }

}