package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by manjeet.singh on 4/9/20.
 */
public class NextClosestTime {
   private static String nextClosestTime(String time) {
      if (time == null || time.isEmpty()) {
         return "";
      }

      char[] result = time.toCharArray();
      Character[] digits = new Character[]{result[0],result[1],result[3],result[4]};
      TreeSet<Character> set = new TreeSet<>(Arrays.asList(digits));

      result[4] = next(set, result[4], '9');
      if (digits[3] < result[4]) {
         return new String(result);
      }

      result[3] = next(set, result[3], '5');
      if (digits[2] < result[3]) {
         return new String(result);
      }

      result[1] = next(set, result[1], result[0] == '2' ? '3' : '9');
      if (digits[1] < result[1]) {
         return new String(result);
      }

      result[0] = next(set, result[0], '2');

      return new String(result);
   }

   private static char next(TreeSet<Character> set, char ch, char limit) {
      Character next = set.higher(ch);

      return (next == null || next > limit) ? set.first() : next;
   }

   public static void main(String[] args) {
      System.out.println(nextClosestTime("19:34"));
      System.out.println(nextClosestTime("23:59"));
      System.out.println(nextClosestTime("13:55"));
   }
}
