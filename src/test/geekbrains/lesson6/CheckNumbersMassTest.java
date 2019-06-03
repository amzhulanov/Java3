package geekbrains.lesson6;

import geekbrains.lesson6.HomeWork6.CheckNumbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckNumbersMassTest {
    static int[][] n={{1,1,1,3,4},
                    {1,1,1,1,4},
                    {1,1,1},
                    {4,4,4}};


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {true,n[0]},
                {true,n[1]},
                {true,n[2]},
                {true,n[3]},
        });
    }

    private boolean result;
    private int[] mass;


    public CheckNumbersMassTest(boolean result,int[] mass) {
        this.result = result;
        this.mass = mass;

    }
    private CheckNumbers checkNumbers;

    @Before
    public void init(){
        checkNumbers=new CheckNumbers();
    }

    @Test
    public void testCheckNumbers(){
        Assert.assertEquals(result,checkNumbers.checkNum(mass));
    }

}
