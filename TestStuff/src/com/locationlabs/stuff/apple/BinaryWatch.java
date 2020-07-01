package com.locationlabs.stuff.apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 5/28/20.
 */
public class BinaryWatch {
   private static List<String> readBinaryWatch(int num) {
      if (num <= 0) {
         return new ArrayList<>();
      }

      final List<String> result = new ArrayList<>();

      for (int i = 0; i < 12; i++) {
         for (int j = 0; j < 60; j++) {
            if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
               result.add(String.format("%d.%02d", i, j));
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(String.format("%02d", 20));
      System.out.println(readBinaryWatch(1));
   }
}
