package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 3/27/19.
 */
public class BestTimeToBuySellStock {

   private static int maxProfit(int[] prices) {
      int minPrice = Integer.MAX_VALUE;
      int maxProfit = 0;

      for(int price : prices) {
         minPrice = Math.min(minPrice, price);
         maxProfit = Math.max(maxProfit, (price-minPrice));
      }
      return maxProfit;
   }

   /**
    * Buy and Sell stock II
    * Can do as many transactions as possible.
    */
   private static int maxProfitII(int[] prices) {
      if (prices == null || prices.length < 2) {
         return 0;
      }

      int maxProfit = 0;

      for (int i = 1; i < prices.length; i++) {
         if (prices[i] > prices[i - 1]) {
            maxProfit += (prices[i] - prices[i - 1]);
         }
      }

      return maxProfit;
   }

   // Complete at most two transactions.
   // You must sell the stock before you buy again.
   private static int buySellIII(int[] prices) {
      if (prices == null || prices.length < 2) {
         return 0;
      }

      int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
      for (int price : prices) {
         buy1 = Math.max(buy1, -price);
         sell1 = Math.max(sell1, buy1 + price);
         buy2 = Math.max(buy2, sell1 - price);
         sell2 = Math.max(sell2, buy2 + price);
      }

      return sell2;
   }

   private static int buySellIV(int[] prices, int k) {
      if (prices == null || prices.length < 2) {
         return 0;
      }

      if (k >= prices.length / 2) {
         int profit = 0;
         for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
               profit += prices[i] - prices[i - 1];
            }
         }
         return profit;
      }

      int[] buy = new int[k + 1], sell = new int[k + 1];
      Arrays.fill(buy, Integer.MIN_VALUE);
      for (int price : prices) {
         for (int i = 1; i <= k; i++) {
            buy[i] = Math.max(buy[i], sell[i - 1] - price);
            sell[i] = Math.max(sell[i], buy[i] + price);
         }
      }
      return sell[k];
   }

   private static int buySellWithCoolDown(int[] prices) {
      if (prices == null || prices.length < 2) {
         return 0;
      }

      int buy = Integer.MIN_VALUE, prevBuy, sell = 0, prevSell = 0;
      for (int price : prices) {
         prevBuy = buy;
         buy = Math.max(prevBuy, prevSell - price);
         prevSell = sell;
         sell = Math.max(prevSell, prevBuy + price);
      }

      return sell;
   }

   private static int buySellWithCoolDownAppraoch2(int[] prices) {
      if (prices == null || prices.length < 2) {
         return 0;
      }

      int[] buy = new int[prices.length];
      int[] sell = new int[prices.length];
      int[] rest = new int[prices.length];

      buy[0] = -prices[0];
      sell[0] = 0;
      rest[0] = 0;
      for (int i = 1; i < prices.length; i++) {
         buy[i] = Math.max(buy[i-1], rest[i-1]-prices[i]);
         rest[i] = Math.max(rest[i-1], sell[i-1]);
         sell[i] = Math.max(sell[i-1], buy[i] + prices[i]);
      }

      return Math.max(rest[prices.length-1], sell[prices.length-1]);
   }

   public static void main(String[] args) {
      /*System.out.println(maxProfit(new int[]{7,6,4,3,1}));
      System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
      System.out.println(maxProfit(new int[]{1,2,3,4,5,6}));*/

      /*System.out.println(maxProfitII(new int[]{7,6,4,3,1}));
      System.out.println(maxProfitII(new int[]{7,1,5,3,6,4}));
      System.out.println(maxProfitII(new int[]{1,2,3,4,5}));*/

      /*System.out.println(buySellWithCoolDown(new int[]{1,2,3,0,2}));
      System.out.println(buySellWithCoolDownAppraoch2(new int[]{1,2,3,0,2}));*/

      System.out.println(buySellIII(new int[]{3,3,5,0,0,3,1,4}));
      System.out.println(buySellIII(new int[]{1,2,3,4,5}));
      System.out.println(buySellIII(new int[]{7,6,4,3,1}));

      /*System.out.println(buySellIV(new int[]{2, 4, 1}, 2));
      System.out.println(buySellIV(new int[]{3,2,6,5,0,3}, 2));*/
   }
}
