package edu.temple.cis.paystation;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class Linear2Test {
    RateStrategy rateStrategy;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setup() {
        rateStrategy = new Linear2();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void Calc_Linear2(){
        assertEquals("5cents with Linear2 rate will give 1min",
                1, rateStrategy.calculateTime(5));

        assertEquals("10cents with Linear2 rate will give 2min",
                2, rateStrategy.calculateTime(10));
    }
}
