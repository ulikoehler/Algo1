/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btronik.mss;

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

    static void test(MSSAlgorithm algorithm) {
        ArrayList<Double> data = Lists.newArrayList(5.0, -2.0, 5.0, -2.0, 1.0, -9.0, 5.0, -2.0, 4.0, -5.0, 1.0, -2.0, 3.0, -1.0, 5.0, -3.0, 2.0, -1.0, 2.0);
        MSSResult result = algorithm.calculate(data);
        assertEquals(0, result.startIndex);
        assertEquals(2, result.endIndex);
        assertEquals(8, result.score);
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
    void testNaive() {
        test(new NaiveAlgorithm());
    }

    @Test
    void testLinear() {
        test(new LinearAlgorithm());
    }

    @Test
    void testOther() {
        test(new DynamicAlgorithm());
    }
}