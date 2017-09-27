package com.codegolf.team0.challenge_d;

public class DayTrader{

    private double bestBuyPrice = 0;
    private double lowestBuyPrice = 0;
    private double bestSellPrice = 0;
    private double maxProfit = 0;
    private boolean buyExists = false;
    private boolean sellExists = false;

    public void accept(double[] prices) {
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
                if ((price - lowestBuyPrice) > maxProfit) {
                    bestBuyPrice = lowestBuyPrice;
                    bestSellPrice = price;
                    maxProfit = bestSellPrice - bestBuyPrice;
                }
            }
        }
    }

    public void printBestDayTrade() {
        if (sellExists && buyExists) {
            System.out.printf("Buy at %.2f sell at %.2f for a profit of %.2f.", bestBuyPrice, bestSellPrice,maxProfit);
        } else if (buyExists){
            System.out.println("Stock price never went up at any time.");
        } else {
            System.out.println("No stock prices were given.");
        }
    }
}
