package com.codegolf.team0.challenge_d;

public class Team0_Q4 {

    public static void main(String[] args) {
        double[] prices = {19.35, 19.30, 18.88, 18.93, 18.95, 19.03, 19.00, 18.97, 18.97, 18.98};

        findBestDayTrade(prices);
    }

    public static void findBestDayTrade(double... prices) {
        DayTrader trader = new DayTrader();
        trader.accept(prices);
        trader.printBestDayTrade();
    }
}
