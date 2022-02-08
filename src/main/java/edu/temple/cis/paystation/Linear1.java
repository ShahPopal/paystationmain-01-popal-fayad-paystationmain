package edu.temple.cis.paystation;

public class Linear1 implements RateStrategy{
    public int calculateTime(int insertedSoFar){
        int time = 0;
        time = (insertedSoFar * 2) / 5;
        return time;
    }
}
