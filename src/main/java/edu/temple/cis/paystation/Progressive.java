package edu.temple.cis.paystation;

public class Progressive implements RateStrategy{
    public int calculateTime(int insertedSoFar) {
        int time = 0;
        if (insertedSoFar < 150) {
            time = (insertedSoFar * 2) / 5;
        } else if(insertedSoFar < 350){
            time = ((insertedSoFar - 150) * 3 / 10) + 60;
        } else{
            time = (insertedSoFar - 350) / 5 + 120;
        }
        return time;
    }
}