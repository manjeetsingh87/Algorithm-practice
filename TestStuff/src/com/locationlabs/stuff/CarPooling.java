package com.locationlabs.stuff;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by manjeet.singh on 10/16/19.
 */
public class CarPooling {
   private static boolean carPooling(int[][] trips, int capacity) {
      final Map<Integer, Integer> map = new TreeMap<>();
      for (int[] trip : trips) {
         map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
         map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
      }

      for (int currCap : map.values()) {
         capacity -= currCap;
         if (capacity < 0) {
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
      System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
      System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
      System.out.println(carPooling(new int[][]{{3, 2, 7}, {3, 7, 9}}, 11));
   }
}
