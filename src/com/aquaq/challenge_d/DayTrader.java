package com.aquaq.challenge_d;


public class DayTrader {

    public static void main(String[] args) {
        Double[] prices = {19.35, 19.30, 18.88, 18.93, 18.95, 19.03, 19.00, 18.97, 18.97, 18.98};

        //Double[] prices = {};

        System.out.println(calculateBestPrices(prices));

    }

    public static String calculateBestPrices(Double[] prices) {

        if (prices.length == 0) {
            return "No prices added";
        }

        double lowestBuyPrice = prices[0];
        double bestBuyPrice = 0;
        double bestSellPrice = 0;
        double bestProfit = 0;

        boolean sellMade = false;

        String message;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < lowestBuyPrice) {
                lowestBuyPrice = prices[i];
            }

            if (!sellMade && prices[i] > lowestBuyPrice) {
                bestBuyPrice = lowestBuyPrice;
                bestSellPrice = prices[i];
                bestProfit = bestSellPrice - bestBuyPrice;
                sellMade = true;

            } else if ((prices[i] - lowestBuyPrice) > bestProfit) {
                bestBuyPrice = lowestBuyPrice;
                bestSellPrice = prices[i];
                bestProfit = bestSellPrice - bestBuyPrice;
            }

        }

        if (bestProfit == 0) {
            message = "No stock improvements, prices continued to fall";
        } else {
            message = String.format("Best profit: %.2f. Buy at: %.2f. Sell at: %.2f",
                    bestProfit, bestBuyPrice, bestSellPrice);
        }
        return message;

    }

}
