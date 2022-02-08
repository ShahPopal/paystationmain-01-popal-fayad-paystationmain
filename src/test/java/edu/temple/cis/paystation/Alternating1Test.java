package edu.temple.cis.paystation;
import org.junit.*;
import java.util.Calendar;
import static org.junit.Assert.assertEquals;

public class Alternating1Test {
    RateStrategy rateStrategy;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setup() {

        rateStrategy = new Alternating1();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void Calc_alternating1(){
        Calendar today = Calendar.getInstance();
        int date;
        for( date = 6; date < 11; date ++){
            today.set(2000, 1, date);
            assertEquals("10cents with Progressive rate will give 4min",
                    4,  rateStrategy.calculateTime(10));
        }

        for( date = 11; date < 13; date ++){

            today.set(2000, 1, date);
            assertEquals("10cents with Linear1 rate will give 4min",
                    4,  rateStrategy.calculateTime(10));
        }
    }
}
