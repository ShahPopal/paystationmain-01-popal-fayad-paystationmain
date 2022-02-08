package edu.temple.cis.paystation;
import java.util.Calendar;

public class Alternating1 implements RateStrategy {

    public int calculateTime(int insertedSoFar){
        int Time = 0;
        Calendar today = Calendar.getInstance();

        if (today.get(Calendar.DAY_OF_WEEK) < 6) {
            RateStrategy rate = new Progressive();
            Time = rate.calculateTime(insertedSoFar);
        } else {
            RateStrategy rate = new Linear1();
            Time = rate.calculateTime(insertedSoFar);
        }
        return Time;
    }
}
