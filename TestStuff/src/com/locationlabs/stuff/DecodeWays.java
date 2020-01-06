package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/3/19.
 */
public class DecodeWays {
   private static int numDecodings(String s) {
      if (s == null || s.length() == 0) {
         return 0;
      }

      int n = s.length();
      int[] noOfWays = new int[n+1];
      noOfWays[0] = 1;
      noOfWays[1] = s.charAt(0) != '0' ? 1 : 0;

      for (int i = 2; i <= n; i++) {
         int first = Integer.valueOf(s.substring(i-1, i));
         int second = Integer.valueOf(s.substring(i-2, i));

         if (first >= 1 && first <= 9) {
            noOfWays[i] += noOfWays[i-1];
         }

         if (second >= 10 && second <= 26) {
            noOfWays[i] += noOfWays[i-2];
         }
      }

      return noOfWays[n];
   }

   public static void main(String[] args) {
      System.out.println(numDecodings("1212"));
      System.out.println(numDecodings("012"));
   }
}
