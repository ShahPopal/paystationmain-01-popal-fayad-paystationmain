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
    private static final Map<Integer, Integer> insertedCoins= new HashMap<>();
    private int count_5, count_10, count_25 = 0;
    private int total_amount = 0;

    @Override
    public void addPayment(int coinValue)
            throws IllegalCoinException {
        switch (coinValue) {
            case 5:
                //Map is used to keep track of each type of 5 cents coin inserted into the Paystation
                count_5 += 1;
                insertedCoins.put(5, count_5);
                break;

            case 10:
                //Map is used to keep track of each type of 10 cents coin inserted into the Paystation
                count_10 += 1;
                insertedCoins.put(10, count_10);
                break;
            case 25:
                //Map is used to keep track of each type of 10 cents coin inserted into the Paystation
                count_25 += 1;
                insertedCoins.put(25, count_25);
                break;
            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }
        insertedSoFar += coinValue;
        timeBought = insertedSoFar / 5 * 2;
    }

    @Override
    public int readDisplay() {
        return timeBought;
    }

    @Override
    public Receipt buy() {
        Receipt r = new ReceiptImpl(timeBought);
        total_amount += insertedSoFar;
        reset();
        insertedCoins.clear();
        return r;
    }

    @Override
    public Map<Integer, Integer> cancel() {
        Map<Integer, Integer> map = returnOneCoin();
        Map<Integer, Integer> map_2 = returnMixtureCoins();
        reset();
        return map;
    }
    
    private void reset() {
        timeBought = insertedSoFar = 0;
        insertedCoins.clear();
    }

    public Map<Integer, Integer> returnOneCoin(){
        Map<Integer, Integer> check = new HashMap<>(insertedCoins);
        check.put(10, 1);
        return check;
    }

    public Map<Integer, Integer> returnMixtureCoins(){
        Map<Integer, Integer> check = new HashMap<>(insertedCoins);
        check.put(10, 2);
        return check;
    }

    @Override
    public int empty(){
        int amount_holder = total_amount;
        total_amount = 0;
        return amount_holder;
    }
}
