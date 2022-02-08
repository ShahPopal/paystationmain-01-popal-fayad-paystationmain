package edu.temple.cis.paystation;
import java.util.Calendar;

public class Alternating2 implements RateStrategy{
    public int calculateTime(int insertedSoFar){
        int time = 0;
        Calendar today = Calendar.getInstance();
        if (today.get(Calendar.DAY_OF_WEEK) < 6){
            RateStrategy rate = new Linear1();
            time = rate.calculateTime(insertedSoFar);
        }else{
            return 0;
        }
        return time;
    }
}
