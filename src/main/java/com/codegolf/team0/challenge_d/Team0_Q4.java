package com.codegolf.team0.challenge_d;

public class Team0_Q4 {

    public static void main(String[] args) {
        findBestDayTrade(19.35, 19.30);
    }

    public static void findBestDayTrade(double... prices) {
        double bestBuyPrice = 0;
        double lowestBuyPrice = 0;
        double bestSellPrice = 0;
        double maxProfit = 0;
        boolean buyExists = false;
        boolean sellExists = false;
        for (double price : prices) {
            if (!buyExists) {
                lowestBuyPrice = price;
                buyExists = true;
            } else if (!sellExists) {
                if (price > lowestBuyPrice) {
                    bestBuyPrice = lowestBuyPrice;
                    bestSellPrice = price;
                    maxProfit = bestSellPrice - bestBuyPrice;
                    sellExists = true;
                } else {
                    lowestBuyPrice = price;
                }
            } else {
                if (price < lowestBuyPrice) {
                    lowestBuyPrice = price;
                }
                if ((price - lowestBuyPrice)>maxProfit) {
                    bestBuyPrice = lowestBuyPrice;
                    bestSellPrice = price;
                    maxProfit = bestSellPrice - bestBuyPrice;
                }
            }
        }
        System.out.println("Buy at " + bestBuyPrice + " sell at " + bestSellPrice + " for a profit of " + maxProfit);
    }
}
