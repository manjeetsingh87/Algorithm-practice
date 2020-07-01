package com.locationlabs.stuff.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class StockSpanner {
   private Deque<int[]> stack;

   public StockSpanner() {
      this.stack = new ArrayDeque<>();
   }

   public int next(int price) {
      int result = 1;
      while (!stack.isEmpty() && stack.peek()[0] <= price) {
         result += stack.pop()[1];
      }

      stack.push(new int[]{price, result});

      return result;
   }

   public static void main(String[] args) {
      final int[] prices = {100, 80, 60, 70, 60, 75, 85};
      final StockSpanner stockSpanner = new StockSpanner();
      for (int price: prices) {
         System.out.println(stockSpanner.next(price));
      }
   }
}
