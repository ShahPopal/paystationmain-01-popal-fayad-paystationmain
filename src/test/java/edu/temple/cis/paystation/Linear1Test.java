package edu.temple.cis.paystation;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class Linear1Test {
    RateStrategy ratestrategy;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setup() {
        ratestrategy = new Linear1();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void Calc_Linear1(){
        assertEquals("5cents with Linear1 rate will give 2min",
                2, ratestrategy.calculateTime(5));

        assertEquals("10cents with Linear1 rate will give 4min",
                4, ratestrategy.calculateTime(10));
    }
}
