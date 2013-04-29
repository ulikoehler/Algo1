/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mss;

import mss.LinearAlgorithm;
import mss.MSSAlgorithm;
import mss.NaiveAlgorithm;
import mss.MSSResult;
import mss.RecursiveAlgorithm;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author uli
 */
public class MSSAlgorithmTest {

    static void test1(MSSAlgorithm algorithm) {
        ArrayList<Double> data = Lists.newArrayList(5.0, -2.0, 5.0, -2.0, 1.0, -9.0, 5.0, -2.0, 4.0, -5.0, 1.0, -2.0, 3.0, -1.0, 5.0, -3.0, 2.0, -1.0, 2.0);
        MSSResult result = algorithm.calculate(data);
        assertEquals(0, result.startIndex);
        assertEquals(2, result.endIndex);
        assertEquals(8, result.score, 0.0000001);
    }

    static void test2(MSSAlgorithm algorithm) {
        ArrayList<Double> data = Lists.newArrayList(-1.0, 0.0, 2.0, -1.0, 2.0, 3.0, -5.0, 3.0);
        MSSResult result = algorithm.calculate(data);
        assert (1 == result.startIndex || 2 == result.startIndex);
        assertEquals(5, result.endIndex);
        assertEquals(6, result.score, 0.0000001);
    }

    public MSSAlgorithmTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNaive() {
        test1(new NaiveAlgorithm());
        test2(new NaiveAlgorithm());
    }

    @Test
    public void testLinear() {
        test1(new LinearAlgorithm());
        test2(new LinearAlgorithm());
    }

    @Test
    public void testOther() {
        test1(new RecursiveAlgorithm());
        test2(new RecursiveAlgorithm());
    }
}