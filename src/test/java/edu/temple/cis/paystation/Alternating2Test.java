package edu.temple.cis.paystation;
import org.junit.*;
import java.util.Calendar;
import static org.junit.Assert.assertEquals;

public class Alternating2Test {
    RateStrategy rate;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setup() { rate = new Linear1(); }

    @After
    public void tearDown() {
    }

    @Test
    public void alternating2CalculatesCorrectly(){

        Calendar today = Calendar.getInstance();
        int date;
        for(date = 6; date < 11; date ++){
            today.set(2021, 9, date);
            assertEquals("10c with Linear1 rate will give 4 min",
                    4, rate.calculateTime(10));
        }

        for(date = 11; date < 13; date ++){
            today.set(2021, 9, date);
            assertEquals("Free on the weekends",
                    0, rate.calculateTime(10));
        }
    }
}