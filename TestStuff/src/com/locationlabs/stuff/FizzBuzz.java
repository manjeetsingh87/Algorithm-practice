package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class FizzBuzz {
   private static List<String> fizzBuzz(int n) {
      final List<String> result = new ArrayList<>();

      final String fizz = "Fizz";
      final String buzz = "Buzz";
      final String fizBuz = fizz.concat(buzz);

      for (int i = 1; i <= n; i++) {
         if (isDivisbleBy3(i) && isDivisbleBy5(i)) {
            result.add(fizBuz);
         } else if (isDivisbleBy3(i)) {
            result.add(fizz);
         } else if (isDivisbleBy5(i)) {
            result.add(buzz);
         } else {
            result.add(String.valueOf(i));
         }
      }
      return result;
   }

   private static boolean isDivisbleBy3(int num) {
      return num % 3 == 0;
   }

   private static boolean isDivisbleBy5(int num) {
      return num % 5 == 0;
   }

   public static void main(String[] args) {
      System.out.println(fizzBuzz(15));
   }
}
