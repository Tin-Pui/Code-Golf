package com.codegolf.team0.challenge_d;

/**
 * Challenge D  - Day Trader
 * So I'm a day trader on the stock market;
 * I want to buy low and sell high, making the biggest gain possible.
 * For this challenge you have a list of prices for the stock you're trading,
 * and I want you to make a single buy, followed by a single sell to make the max profit.
 * The return of the function should be the price you bought at, followed by the sell price.
 * Obviously you can't buy in the future or sell in the past, so the buy price must come first
 *
 * For example if the list is:
 * 19.35 19.30 18.88 18.93 18.95 19.03 19.00 18.97 18.97 18.98
 *
 * The answer is:
 * 18.88 19.03
 */
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
