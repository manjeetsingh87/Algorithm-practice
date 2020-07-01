package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/13/20.
 */
public class HappyNumber {
   private static boolean isHappy(int n) {
      if (n == 0) {
         return false;
      }

      int slow = n, fast = getNext(n);

      while (fast != 1 && slow != fast) {
         slow = getNext(slow);
         fast = getNext(getNext(fast));
      }

      return fast == 1;
   }

   private static int getNext(int num) {
      int total = 0;
      while (num > 0) {
         int rem = num % 10;
         num /= 10;
         total += rem * rem;
      }
      return total;
   }

   public static void main(String[] args) {
      System.out.println(isHappy(49));
      System.out.println(isHappy(19));
   }
}
