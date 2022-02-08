package edu.temple.cis.paystation;

public class Linear2 implements RateStrategy{
    public int calculateTime(int insertedSoFar){
        int time = 0;
        time = insertedSoFar / 5;
        return time;
    }
}
