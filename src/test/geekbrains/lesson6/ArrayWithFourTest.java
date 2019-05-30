package geekbrains.lesson6;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import geekbrains.lesson6.HomeWork6.ArrayWithFour;

public class ArrayWithFourTest {
    private ArrayWithFour arrayWithFour;

    @Before
    public void init(){
        arrayWithFour=new ArrayWithFour();
    }
    @Test
    public void testAfterFour(){
        int[] mass = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] mass_res = {5, 6, 7, 8};
        Assert.assertArrayEquals(mass_res,arrayWithFour.afterFour(mass));
    }
    @Test(expected = AssertionError.class)
    public void testSizeArraynAfterFour(){
        int[] mass3 = {1, 21, 33, 64, 75, 4, 7, 8};
        int[] mass3_res = {1, 21, 33, 64, 75, 4, 7, 8};
        Assert.assertArrayEquals(mass3_res,arrayWithFour.afterFour(mass3));

    }

    @Test(expected = RuntimeException.class)
    public void exceptionAfterFour(){
        int[] mass4 = {2, 3, 5, 6, 7, 8};
        int[] mass4_res = {};
        Assert.assertArrayEquals(mass4_res,arrayWithFour.afterFour(mass4));
    }
}
