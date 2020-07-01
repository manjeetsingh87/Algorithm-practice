package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/11/20.
 */
public class ShipPackagesWithinDDays {
   private static int shipWithinDays(int[] weights, int D) {
      if (weights == null || weights.length == 0 || D < 1) {
         return 0;
      }

      int left = 0;
      int right = 0;

      for (int weight : weights) {
         left = Math.max(left, weight);
         right += weight;
      }

      // binary search
      while (left <= right) {
         final int mid = (left + right) / 2;
         final boolean canShip = canShip(weights, D, mid);

         if (canShip) {
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }

      return left;
   }

   private static boolean canShip(int[] weights, int totalDays, int capacity) {
      int days = 1, currWeight = 0;

      for (int weight : weights) {
         if (weight > capacity || days > totalDays) {
            return false;
         }

         currWeight += weight;
         if (currWeight > capacity) {
            currWeight = weight;
            days++;
         }
      }

      return days <= totalDays;
   }

   public static void main(String[] args) {
      System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
      System.out.println(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
      System.out.println(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
      System.out.println(shipWithinDays(new int[]{10,50,100,100,50,100,100,100}, 5));
   }
}
