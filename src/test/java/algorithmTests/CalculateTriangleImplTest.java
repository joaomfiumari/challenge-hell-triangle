package algorithmTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algorithm.TriangleCalcImpl;
import exceptions.TriangleException;


/**
 * Created by joaopaulo on 29/01/17.
 */
public class CalculateTriangleImplTest {

    private TriangleCalcImpl calculator;


    @Before
    public void before(){
        this.calculator = new TriangleCalcImpl();
    }


    @Test(expected = TriangleException.class)
    public void nullTest(){
        this.calculator.calculate(null);
    }

    @Test(expected = TriangleException.class)
    public void emptyTest(){
        this.calculator.calculate(new int[][]{});
    }

    @Test(expected = TriangleException.class)
    public void invalidLengthTest(){
        this.calculator.calculate(new int[][]{{6}, {9, 7, 1}});
    }

    @Test
    public void onlyOneRowValid(){
        long nanos = System.nanoTime();
        final int value = this.calculator.calculate(new int[][]{{6}});
        nanos = System.nanoTime() - nanos;
        System.out.printf("Maximum value in 'onlyOneRowValid' is %d (in %.3fms)\n", value, nanos / 1000000.0);
		Assert.assertEquals(6, value);
    }

    @Test
    public void twoRowsValid(){
        long nanos = System.nanoTime();
        final int value = this.calculator.calculate(new int[][]{{6}, {3, 5}});
        nanos = System.nanoTime() - nanos;
        System.out.printf("Maximum value in 'twoRowsValid' is %d (in %.3fms)\n", value, nanos / 1000000.0);
        Assert.assertEquals(11, value);
    }

    @Test
    public void threeRowsValid(){
         long nanos = System.nanoTime();
        final int value = this.calculator.calculate(new int[][]{{6}, {3, 5}, {9, 7, 1}});
        nanos = System.nanoTime() - nanos;
        System.out.printf("Maximum value in 'threeRowsValid' is %d (in %.3fms)\n", value, nanos / 1000000.0);
        Assert.assertEquals(18, value);
    }

    @Test
    public void fourRowsValid(){
        long nanos = System.nanoTime();
        final int value = this.calculator.calculate(new int[][]{{6}, {3, 5}, {9, 7, 1}, {4, 6, 8, 4}});
        nanos = System.nanoTime() - nanos;
        System.out.printf("Maximum value in 'fourRowsValid' is %d (in %.3fms)\n", value, nanos / 1000000.0);
        Assert.assertEquals(26, value);
    }


}
