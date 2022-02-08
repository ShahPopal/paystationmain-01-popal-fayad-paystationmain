/**
 * Implementation of the pay station.
 *
 * Responsibilities:
 *
 * 1) Accept payment; 
 * 2) Calculate parking time based on payment; 
 * 3) Know earning, parking time bought; 
 * 4) Issue receipts; 
 * 5) Handle buy and cancel events.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
package edu.temple.cis.paystation;
import java.util.HashMap;
import java.util.Map;

public class PayStationImpl implements PayStation {

    private int insertedSoFar;
    private int timeBought;
    private int totalMoney;
    private Map<Integer, Integer> insertedCoin;
    RateStrategy RateStrategy;

    // Constructor initializes instance variables
    public PayStationImpl(){
        insertedSoFar = timeBought = totalMoney = 0;
        insertedCoin = new HashMap<>();
    }

    @Override
    public void addPayment(int coinValue)
            throws IllegalCoinException {

        switch (coinValue) {
            case 5:
            case 10:
            case 25:
                break;
            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }

        insertedCoin.put(coinValue, insertedCoin.getOrDefault(coinValue, 0) + 1);

        insertedSoFar += coinValue;
        if(this.RateStrategy == null){
            setRateStrategy(1);
        }else{
            timeBought = RateStrategy.calculateTime(insertedSoFar);
            //timeBought = insertedSoFar / 5 * 2;
        }

    }

    @Override
    public int readDisplay() {
        return timeBought;
    }

    @Override
    public Receipt buy() {
        Receipt receipt = new ReceiptImpl(timeBought);
        totalMoney += insertedSoFar;
        reset();
        return receipt;
    }

    @Override
    public Map<Integer, Integer> cancel()
    {
        Map<Integer, Integer> tempMap = insertedCoin;
        insertedCoin = new HashMap<>();
        reset();
        return tempMap;
    }

    private void reset() {
        timeBought = insertedSoFar = 0;
        insertedCoin.clear();
    }

    @Override
    public int empty()
    {
        int temp = totalMoney;
        totalMoney = 0;
        return temp;
    }

    public void setRateStrategy(int user_Input){
        switch (user_Input){
            case 1:
                RateStrategy = new Linear1();
                System.out.println("Alphatown");
                break;
            case 2:
                RateStrategy=new Progressive();
                System.out.println("Betatown");
                break;
            case 3:
                RateStrategy=new Alternating1();
                System.out.println("Gammatown");
                break;
            case 4:
                RateStrategy = new Linear2();
                System.out.println("Deltatown");
                break;
            case 5:
                RateStrategy = new Alternating2();
                System.out.println("Omegatown");
                break;

        }
        timeBought = RateStrategy.calculateTime(insertedSoFar);
    }
}
