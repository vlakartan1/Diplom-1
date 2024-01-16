package praktikum;


import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private final String nameBun = "Булочка";


    @Test
    public void testGetName() {
        bun = new Bun(nameBun, 20f);
        assertEquals(nameBun, bun.getName());
    }

    @Test
    public void testGetPrice() {
        float priceBun = 1.20f;
        bun = new Bun(nameBun, priceBun);
        assertEquals(priceBun, bun.getPrice(), 0.01f);
    }

}