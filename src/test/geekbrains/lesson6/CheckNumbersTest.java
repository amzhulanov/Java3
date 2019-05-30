package geekbrains.lesson6;

import geekbrains.lesson6.HomeWork6.CheckNumbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckNumbersTest {

    private CheckNumbers checkNumbers;

    @Before
    public void init(){
        checkNumbers=new CheckNumbers();
    }

    @Test
    public void testCheckNumbers(){
        int[] mass={1,2,1,1,1,4};
        Assert.assertEquals(true,checkNumbers.checkNum(mass));
    }


}
