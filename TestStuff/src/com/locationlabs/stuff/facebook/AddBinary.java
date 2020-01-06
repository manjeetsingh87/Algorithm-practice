package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class AddBinary {
   private static String addBinary(String a, String b) {
      int len1 = a.length() - 1, len2 = b.length() - 1, carry = 0;
      final StringBuilder binary = new StringBuilder();
      while (len1 >= 0 || len2 >= 0 || carry != 0) {
         int sum = ((len1 < 0) ? 0 : a.charAt(len1) - '0') + ((len2 < 0) ? 0 : b.charAt(len2) - '0') + carry;
         binary.append(sum % 2);
         carry = sum / 2;
         len1--;
         len2--;
      }
      return binary.reverse().toString();
   }

   public static void main(String[] args) {
      System.out.println(addBinary("11", "1"));
      System.out.println(addBinary("1010", "1011"));
   }
}
