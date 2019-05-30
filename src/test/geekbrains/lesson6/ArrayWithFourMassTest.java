package geekbrains.lesson6;

import geekbrains.lesson6.HomeWork6.ArrayWithFour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayWithFourMassTest {
    static int massiv[][]={{1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 5, 6, 7, 8},
            {1, 2, 3, 5, 6, 7, 4}};

    static int result[][]={{5,6,7,8},
            {1},
            {}};

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {result[0],massiv[0]},
                {result[1],massiv[1]},
                {result[2],massiv[2]}
             });

    }

    private int[] res;
    private int[] mass;

    public ArrayWithFourMassTest(int[] res, int[] mass) {
        this.res = res;
        this.mass = mass;
    }

    private ArrayWithFour arrayWithFour;

    @Before
    public void init() {
        arrayWithFour = new ArrayWithFour();
    }

    @Test(expected = RuntimeException.class)
    public void testArrayWithFourMassTest(){
        Assert.assertArrayEquals(res,arrayWithFour.afterFour(mass));
    }
}
