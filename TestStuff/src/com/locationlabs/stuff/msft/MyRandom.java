package com.locationlabs.stuff.msft;

import java.util.Random;

/**
 * Created by manjeet.singh on 4/13/20.
 * https://leetcode.com/problems/implement-rand10-using-rand7/discuss/338395/In-depth-straightforward-detailed-explanation.-Java-Solution.
 */
public class MyRandom {
   private static final Random random = new Random();

   private static int rand10() {
      int rand40 = Integer.MAX_VALUE;
      while (rand40 >= 40) {
         rand40 = (rand7() - 1) * 7 + rand7() - 1;
      }

      return rand40 % 10 + 1;
   }

   private static int rand7() {
      int rand = random.nextInt(7);
      while (rand <= 0) {
         rand = random.nextInt(7);
      }
      return rand;
   }

   public static void main(String[] args) {
      System.out.println(rand10());
      System.out.println(rand10());
      System.out.println(rand10());
      System.out.println(rand10());
      System.out.println(rand10());
      System.out.println(rand10());
   }
}
