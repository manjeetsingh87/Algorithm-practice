package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/22/20.
 */
public class CountAndSay {
   private static String countAndSay(int n) {
      if (n == 1) {
         return "1";
      }

      String prev = countAndSay(n - 1);

      StringBuilder sb = new StringBuilder();
      int count = 1;
      char prevNum = prev.charAt(0);
      for (int i = 1; i < prev.length(); i++) {
         char currNum = prev.charAt(i);
         if (currNum == prevNum) {
            count += 1;
         } else {
            sb.append(count).append(prevNum);
            count = 1;
         }
         prevNum = currNum;
      }

      sb.append(count).append(prevNum);
      return sb.toString();
   }

   public static void main(String[] args) {
      System.out.println(countAndSay(1));
      System.out.println(countAndSay(4));
      System.out.println(countAndSay(5));
   }
}
