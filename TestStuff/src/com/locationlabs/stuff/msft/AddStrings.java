package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/2/20.
 */
public class AddStrings {
   private static String addStrings(String num1, String num2) {
      if (num1 == null && num2 == null) {
         return null;
      }

      if (num1.isEmpty() && num2.isEmpty()) {
         return null;
      }

      StringBuilder sum = new StringBuilder();
      int i = num1.length()-1, j = num2.length()-1;
      int carry = 0;
      while (i >= 0 || j >= 0 || carry == 1) {
         int x = i < 0 ? 0 : num1.charAt(i) - '0';
         int y = j < 0 ? 0 : num2.charAt(j) - '0';
         int currentSum = x + y + carry;
         sum.append(currentSum % 10);
         carry = currentSum / 10;
         i--;
         j--;
      }

      return sum.reverse().toString();
   }
}
