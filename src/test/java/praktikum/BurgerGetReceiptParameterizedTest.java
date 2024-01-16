package praktikum;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParameterizedTest {
    private final Bun bun;
    private final Ingredient[] ingredients;
    private final String expectedReceipt;
    Burger burger = new Burger();

    public BurgerGetReceiptParameterizedTest(Bun bun, Ingredient[] ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Bun("black bun", 100), new Ingredient[]{new Ingredient(IngredientType.SAUCE, "hot sauce", 100)}, "(==== black bun ====)"
                        + System.lineSeparator() + "= sauce hot sauce =" + System.lineSeparator() + "(==== black bun ====)" + System.lineSeparator()
                        + System.lineSeparator() + "Price: 300.000000" + System.lineSeparator()},
                {new Bun("white bun", 200), new Ingredient[]{new Ingredient(IngredientType.SAUCE, "sour cream", 200)}, "(==== white bun ====)"
                        + System.lineSeparator() + "= sauce sour cream =" + System.lineSeparator() + "(==== white bun ====)" + System.lineSeparator()
                        + System.lineSeparator() + "Price: 600.000000" + System.lineSeparator()},
                {new Bun("red bun", 300), new Ingredient[]{new Ingredient(IngredientType.SAUCE, "chili sauce", 300)}, "(==== red bun ====)"
                        + System.lineSeparator() + "= sauce chili sauce =" + System.lineSeparator() + "(==== red bun ====)" + System.lineSeparator()
                        + System.lineSeparator() + "Price: 900.000000" + System.lineSeparator()},
                {new Bun("white bun", 200), new Ingredient[]{new Ingredient(IngredientType.FILLING, "cutlet", 100)}, "(==== white bun ====)"
                        + System.lineSeparator() + "= filling cutlet =" + System.lineSeparator() + "(==== white bun ====)" + System.lineSeparator()
                        + System.lineSeparator() + "Price: 500.000000" + System.lineSeparator()},
                {new Bun("black bun", 100), new Ingredient[]{new Ingredient(IngredientType.FILLING, "dinosaur", 200)}, "(==== black bun ====)"
                        + System.lineSeparator() + "= filling dinosaur =" + System.lineSeparator() + "(==== black bun ====)" + System.lineSeparator()
                        + System.lineSeparator() + "Price: 400.000000" + System.lineSeparator()}
        });
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        assertEquals(burger.getReceipt().replace(",", "."), expectedReceipt);
    }
}