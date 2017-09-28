package com.codegolf.team0.challenge_d;

public class DayTrader {
    private double bestBuyPrice = 0;
    private double lowestBuyPrice = 0;
    private double bestSellPrice = 0;
    private double maxProfit = 0;
    private boolean buyExists = false;
    private boolean sellExists = false;

    public void accept(double[] prices) {
        // algorithm assumes day trader must make a profit with 1 buy order and 1 sell order of the same amount
        for (double price : prices) {
            if (!buyExists) {
                lowestBuyPrice = price;
                buyExists = true;
                sellExists = false;
                maxProfit = 0;
            } else if (price < lowestBuyPrice) {
                lowestBuyPrice = price;
            }

            if (!sellExists && (price > lowestBuyPrice)) {
                bestBuyPrice = lowestBuyPrice;
                bestSellPrice = price;
                maxProfit = bestSellPrice - bestBuyPrice;
                sellExists = true;
            } else if ((price - lowestBuyPrice) > maxProfit) {
                bestBuyPrice = lowestBuyPrice;
                bestSellPrice = price;
                maxProfit = bestSellPrice - bestBuyPrice;
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
