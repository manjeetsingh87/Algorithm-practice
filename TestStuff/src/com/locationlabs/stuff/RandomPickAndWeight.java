package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by manjeet.singh on 7/11/19.
 */
public class RandomPickAndWeight {
   private int[] totals;
   private Random rand;

   public RandomPickAndWeight(int[] w) {
      rand = new Random();
      totals = w.clone();
      for (int i = 1; i < w.length; i++) {
         totals[i] += totals[i-1];
      }
   }

   public int pickIndex() {
      int target = rand.nextInt(totals[totals.length - 1]);
      int lo = 0;
      int hi = totals.length - 1;
      while (lo != hi) {
         int mid = (lo + hi) / 2;
         if (target >= totals[mid]) {
            lo = mid + 1;
         }else {
            hi = mid;
         }
      }
      return lo;
   }

   public static void main(String[] args) {
      RandomPickAndWeight pickAndWeight = new RandomPickAndWeight(new int[]{3, 14, 1, 7});
      System.out.println(pickAndWeight.pickIndex());
      System.out.println(pickAndWeight.pickIndex());
      System.out.println(pickAndWeight.pickIndex());
      System.out.println(pickAndWeight.pickIndex());
   }
}
