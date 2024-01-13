package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bunMock;
    private Bun bun;
    private final String nameBun = "Булочка";
    private final float priceBun = 1.20f;

    @Before
    public void setBunMock() {
        bunMock = mock(Bun.class);
    }

    @Test
    public void testGetName() {
        bun = new Bun(nameBun, 20f);
        assertEquals(nameBun, bun.getName());
    }

    @Test
    public void testGetPrice() {
        bun = new Bun(nameBun, priceBun);
        assertEquals(priceBun, bun.getPrice(), 0.01f);
    }


    @Test
    public void testBunWithMock() {
        when(bunMock.getName()).thenReturn(nameBun);
        when(bunMock.getPrice()).thenReturn(priceBun);

        assertEquals(nameBun, bunMock.getName());
        assertEquals(priceBun, bunMock.getPrice(), 0.01f);
    }

}