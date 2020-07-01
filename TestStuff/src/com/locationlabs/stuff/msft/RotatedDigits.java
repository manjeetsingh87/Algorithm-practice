package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/13/20.
 */
public class RotatedDigits {
   private static final Set<Integer> validNums = new HashSet<>(Arrays.asList(2, 5, 6, 9));
   private static final Set<Integer> invalidNums = new HashSet<>(Arrays.asList(3, 4, 7));

   private static int rotatedDigits(int N) {
      int count = 0;

      for (int i = 1; i <= N; i++) {
         if (isValid(i)) {
            count++;
         }
      }

      return count;
   }

   private static boolean isValid(int num) {
      boolean valid = false;
      while (num > 0) {
         final int rem = num % 10;
         if (invalidNums.contains(rem)) {
            return false;
         }
         if (validNums.contains(rem)) {
            valid = true;
         }
         num /= 10;
      }
      return valid;
   }

   public static void main(String[] args) {
      System.out.println(rotatedDigits(10));
   }
}
