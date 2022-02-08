package edu.temple.cis.paystation;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.Calendar;


public class ProgressiveTest {
    RateStrategy rateStrategy;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setup() {
        rateStrategy = new Progressive();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void Calc_progressive(){

        assertEquals("10cents with Progressive rate should give 4min",
                4, rateStrategy.calculateTime(10));
        assertEquals("150cents with Progressive rate should give 60min",
                60, rateStrategy.calculateTime(150));

        assertEquals("200cents with Progressive rate should give 75min",
                75, rateStrategy.calculateTime(200));

        assertEquals("350cents with Progressive rate should give 120min",
                120, rateStrategy.calculateTime(350));

        assertEquals("400cents with Progressive rate should give 130min",
                130, rateStrategy.calculateTime(400));
    }
}
