package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class IntegerToWord {
   private final static String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
   private final static String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
   private final static String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

   private static String numberToWords(int num) {
      if (num == 0) {
         return "Zero";
      }

      int i = 0;
      String words = "";
      while (num > 0) {
         if (num % 1000 != 0) {
            words = helper(num % 1000) + THOUSANDS[i] + " " + words;
         }

         num /= 1000;
         i++;
      }

      return words.trim();
   }
   private static String helper(int num) {
      if (num == 0) {
         return LESS_THAN_20[0];
      } else if (num < 20) {
         return LESS_THAN_20[num] + " ";
      } else if (num < 100) {
         return TENS[num / 10] + " " + helper(num % 10);
      } else {
         return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
      }
   }

   public static void main(String[] args) {
      System.out.println(numberToWords(123));
//      System.out.println(numberToWords(12345));
//      System.out.println(numberToWords(1234567));
//      System.out.println(numberToWords(1234567891));
   }
}
